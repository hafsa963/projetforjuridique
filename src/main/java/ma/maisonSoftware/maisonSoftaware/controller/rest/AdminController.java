package ma.maisonSoftware.maisonSoftaware.controller.rest;


import io.swagger.v3.oas.models.responses.ApiResponse;
import ma.maisonSoftware.maisonSoftaware.mapper.*;
import ma.maisonSoftware.maisonSoftaware.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private IUserService userService;


    @PostMapping("/saveuser")
    public ResponseEntity<Object> createcolab(@Valid @RequestBody UserVo userVo){
        userService.save(userVo);
        return new ResponseEntity<>("colaborateur  is created successfully", HttpStatus.CREATED);
    }


    @GetMapping(value = "/admin/roles", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<RoleVo> getAll()
    {
        return userService.getAllRoles();
    }
    @GetMapping(value = "/admin/colab", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<UserVo> getAllUsers()
    {
        return userService.getAllUsers();
    }


    @PutMapping(value = "/admin/updateColab/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long userid,@RequestBody UserVo vo) {
        UserVo UserFound = userService.getuserById(userid);
        if (UserFound == null)
            return new ResponseEntity<>("User not found", HttpStatus.OK);
        vo.setId(userid);
        userService.save(vo);

        return ResponseEntity.ok().body(new ApiResponse());

    }

    @DeleteMapping(value ="/admin/deleteColab/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long userid) {
        UserVo UserFound = userService.getuserById(userid);
        if (UserFound == null)
            return new ResponseEntity<>("User not found", HttpStatus.OK);

        userService.delete(userid);

        return ResponseEntity.ok().body(new ApiResponse());

    }

}
