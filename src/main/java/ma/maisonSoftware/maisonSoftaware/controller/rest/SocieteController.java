package ma.maisonSoftware.maisonSoftaware.controller.rest;

import io.swagger.v3.oas.models.responses.ApiResponse;
import ma.maisonSoftware.maisonSoftaware.mapper.ManagerVo;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.service.ISocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/societes")
public class SocieteController {
    @Autowired
    ISocieteService iSocieteService;
    @GetMapping(value = "/admin/societe", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<SocieteVo> getAll() {
        return iSocieteService.getAllSociete();
    }
    @GetMapping(value = "/societe/{id}")
    public ResponseEntity<Object> getSocieteById(@PathVariable(value = "id") Long societeVoId) {
        SocieteVo societeVoFound = iSocieteService.getSocieteById(societeVoId);
        if (societeVoFound == null)
            return new ResponseEntity<>("societe doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeVoFound, HttpStatus.OK);
    }
    @PostMapping(value = "/admin/createSociete")
    public ResponseEntity<Object> createSociete(@Valid @RequestBody SocieteVo societeVo) {
        iSocieteService.save(societeVo);
        return new ResponseEntity<>("societe is created successfully", HttpStatus.CREATED);
    }
    @PostMapping(value = "/admin/createmanager")
    public ResponseEntity<Object> createmanager(@Valid @RequestBody List<ManagerVo> managerVos) {
        iSocieteService.save((SocieteVo) managerVos);
      /*  return new ResponseEntity<>("manager is created successfully", HttpStatus.CREATED);*/
        return ResponseEntity.ok().body(new ApiResponse());


    }
    @PutMapping(value = "/admin/updateSociete/{id}")
    public ResponseEntity<Object> updateSociete(@PathVariable(name = "id") Long societeId,@Valid @RequestBody SocieteVo societeVo) {
        SocieteVo societeVo1Found = iSocieteService.getSocieteById(societeId);
        if (societeVo1Found == null)
            return new ResponseEntity<>("societe doen't exist", HttpStatus.OK);
        societeVo.setId(societeId);
        iSocieteService.save(societeVo);
       /* return new ResponseEntity<>("Societe is updated successsfully", HttpStatus.OK);*/
        return ResponseEntity.ok().body(new ApiResponse());
    }
   /* @DeleteMapping(value = "/admin/deleteSociete/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteSociete(@PathVariable(name = "id") Long societeVoId) {
        SocieteVo societeVoFound = iSocieteService.getSocieteById(societeVoId);
        if (societeVoFound == null)
            return new ResponseEntity<>("societe doen't exist", HttpStatus.OK);
        iSocieteService.delete(societeVoId);
        return new ResponseEntity<>("Societe is deleted successsfully", HttpStatus.OK);
    }*/
   @DeleteMapping(value = "/admin/deleteSociete/{id}")
   //@PreAuthorize("hasRole('ADMIN')")
   public ResponseEntity<Object> deleteSociete(@PathVariable(name = "id") Long societeVoId) {
       SocieteVo societeVoFound = iSocieteService.getSocieteById(societeVoId);
       if (societeVoFound == null) {
           return ResponseEntity.badRequest().body(new ApiResponse());
       }
       iSocieteService.delete(societeVoId);
       return ResponseEntity.ok().body(new ApiResponse());
   }
    @GetMapping(value = "/admin/societe/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSocieteByName(@PathVariable(value = "name") String nameSociete) {
        SocieteVo societeNameFound = iSocieteService.findByNom(nameSociete);
        if (societeNameFound == null)
            return new ResponseEntity<>("societe name doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeNameFound, HttpStatus.OK);
    }
    @GetMapping(value = "/admin/societe/rc/{rc}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSocieteByRc(@PathVariable(value = "rc") long rcSociete) {
        SocieteVo societeRcFound = iSocieteService.findByRc(rcSociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("societe rc doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/societe/sort/{fieldName}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<SocieteVo> sortBy(@PathVariable String fieldName) {
        return iSocieteService.sortBy(fieldName);
    }

    @DeleteMapping(value = "admin/deleteManager/{id}")
    public ResponseEntity<Object> deleteManager(@PathVariable(name = "id") long managerId){
        iSocieteService.deleteManager(managerId);
        return new ResponseEntity<>("manager is deleted successsfully", HttpStatus.OK);

    }
    @PutMapping(value = "admin/associateSocietePrestation/{id}/{id_prestation}")
    public ResponseEntity<String>  associateSocietePrestation(@PathVariable(name ="id") long id_Societe ,@PathVariable (name ="id_prestation") long id)
    {
        try {
            iSocieteService.associateSocietePrestation(id_Societe, id);

            return new ResponseEntity<>("societe is updated prestation succefuly", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Societe or Prestation not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while updating the association", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
