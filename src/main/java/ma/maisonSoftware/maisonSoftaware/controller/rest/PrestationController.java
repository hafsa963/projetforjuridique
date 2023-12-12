package ma.maisonSoftware.maisonSoftaware.controller.rest;

import io.swagger.v3.oas.models.responses.ApiResponse;
import ma.maisonSoftware.maisonSoftaware.mapper.EtapeVo;
import ma.maisonSoftware.maisonSoftaware.mapper.PrestationVo;
import ma.maisonSoftware.maisonSoftaware.mapper.PrestationsomaireVo;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.service.IPrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/prestations")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PrestationController {
    @Autowired
   private IPrestationService iPrestationService;



    @GetMapping(value = "/getAll" ,produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<PrestationsomaireVo> getAll()
    {
        return iPrestationService.getAllPrestation();
    }

    @GetMapping(value = "/prestation/{id}")
    public ResponseEntity<Object> getPrestationById(@PathVariable(value = "id") Long prestationVoId) {
        PrestationVo societeVoFound = iPrestationService.getPestationById(prestationVoId);
        if (societeVoFound == null)
            return new ResponseEntity<>("prestation doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeVoFound, HttpStatus.OK);
    }
    @PostMapping(value = "/prestation")
    public ResponseEntity<Object> createSociete(@Valid @RequestBody PrestationVo prestationVo) {
        iPrestationService.save(prestationVo);
        /*return new ResponseEntity<>("prestation is created successfully", HttpStatus.CREATED);*/
        return ResponseEntity.ok().body(new ApiResponse());
    }
    @PutMapping(value = "/admin/updatePrestation/{id}")
    public ResponseEntity<Object> updatePrestation(@PathVariable(name = "id") Long prestationVo1, @Valid @RequestBody PrestationVo prestationVo) {
        PrestationVo prestationVo1Found = iPrestationService.getPestationById(prestationVo1);

        if (prestationVo1Found == null)
           /* return new ResponseEntity<>("Prestation doen't exist", HttpStatus.OK);*/
        return ResponseEntity.badRequest().body(new ApiResponse());
        prestationVo.setId(prestationVo1);

        iPrestationService.update(prestationVo);
        return ResponseEntity.ok().body(new ApiResponse());
        /*return new ResponseEntity<>("Prestation is updated successsfully", HttpStatus.OK);*/
    }
    @DeleteMapping(value = "/admin/deleteEtape/{id}")
    public ResponseEntity<Object> deleteEtape(@PathVariable(name = "id") Integer etapeId) {
        iPrestationService.deleteEtape(etapeId);
        return new ResponseEntity<>("Etape is deleted successsfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/prestation/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deletePrestation(@PathVariable(name = "id") Long prestationVoId) {
        PrestationVo prestationVoFound = iPrestationService.getPestationById(prestationVoId);
        if (prestationVoFound == null)
            return ResponseEntity.badRequest().body(new ApiResponse());
            /*return new ResponseEntity<>("prestation doen't exist", HttpStatus.OK);*/
        iPrestationService.delete(prestationVoId);
        /*return new ResponseEntity<>("Prestation is deleted successsfully", HttpStatus.OK);*/
        return ResponseEntity.ok().body(new ApiResponse());
    }


    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(value = "prestation/nameprestation/{nameprestation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getbymission(@PathVariable (value = "nameprestation") String nameprestation)
    {
        PrestationVo prestationVofound = iPrestationService.findByNamePrestation(nameprestation);
        if(prestationVofound == null)
            return new ResponseEntity<>("nameprestation doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(prestationVofound, HttpStatus.OK);
    }
    @GetMapping(value = "prestation/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findBySomeProperty(@PathVariable (value = "id") Long id)
    {
        PrestationVo prestationVofound = iPrestationService.findByid(id);
        if(prestationVofound == null)
            return new ResponseEntity<>("prestation rc doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(prestationVofound, HttpStatus.OK);
    }

    @GetMapping(value = "prestationbyetape/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getalletapeByPrestation(@PathVariable (value = "id") Long id)
    {
        PrestationVo prestationVofound = iPrestationService.getalletapeByPrestation(id);
        if(prestationVofound == null)
            return new ResponseEntity<>("societe rc doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(prestationVofound, HttpStatus.OK);
    }

}
