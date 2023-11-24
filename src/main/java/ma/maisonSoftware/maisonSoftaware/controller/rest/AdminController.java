package ma.maisonSoftware.maisonSoftaware.controller.rest;


import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.mapper.UserVo;
import ma.maisonSoftware.maisonSoftaware.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
}
