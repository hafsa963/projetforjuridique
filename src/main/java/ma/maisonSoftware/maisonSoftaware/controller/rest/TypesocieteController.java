package ma.maisonSoftware.maisonSoftaware.controller.rest;


import io.swagger.v3.oas.models.responses.ApiResponse;
import ma.maisonSoftware.maisonSoftaware.mapper.TypeSocieteVo;
import ma.maisonSoftware.maisonSoftaware.service.ITypesocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/typesociete")
public class TypesocieteController {
    @Autowired
    ITypesocieteService iTypesocieteService;

    @GetMapping(value = "/admin/typesociete", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<TypeSocieteVo> getAll()
    {
        return iTypesocieteService.getAllTypeSociete();
    }
    @GetMapping(value = "/typesociete/{id}")
    public ResponseEntity<Object> getTypeSocieteById(@PathVariable(value = "id") Long typeSocieteVoID) {
        TypeSocieteVo typeFound = iTypesocieteService.getTypeSocieteById(typeSocieteVoID);
        if (typeFound == null)
            return new ResponseEntity<>("typeFound doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(typeFound, HttpStatus.OK);
    }
    @PostMapping(value = "/admin/createTypeSociete")
    public ResponseEntity<Object> createTypeSociete(@Valid @RequestBody TypeSocieteVo typeSocieteVo) {
         iTypesocieteService.save(typeSocieteVo);
        return new ResponseEntity<>("typeSociete is created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/admin/updateTypeSociete/{id}")
    public ResponseEntity<Object> updateTypeSociete(@PathVariable(name = "id") Long typeSocieteId,@Valid @RequestBody TypeSocieteVo typeSocieteVo) {
        TypeSocieteVo typeFound = iTypesocieteService.getTypeSocieteById(typeSocieteId);
        if (typeFound == null)
            return new ResponseEntity<>("typeFound doen't exist", HttpStatus.OK);
        typeSocieteVo.setId(typeSocieteId);
        iTypesocieteService.save(typeSocieteVo);
        return ResponseEntity.ok().body(new ApiResponse());
    }

    @DeleteMapping(value = "/admin/DeleteTypeSociete/{id}")
    public ResponseEntity<Object> DeleteTypeSociete(@PathVariable(name = "id") Long  typeSocieteId) {
        TypeSocieteVo typeIdFound = iTypesocieteService.getTypeSocieteById(typeSocieteId);
        if (typeIdFound == null) {
            return ResponseEntity.badRequest().body(new ApiResponse());
        }
        iTypesocieteService.delete(typeSocieteId);
        return ResponseEntity.ok().body(new ApiResponse());
    }
}
