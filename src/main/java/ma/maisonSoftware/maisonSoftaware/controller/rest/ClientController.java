package ma.maisonSoftware.maisonSoftaware.controller.rest;


import io.swagger.v3.oas.models.responses.ApiResponse;
import ma.maisonSoftware.maisonSoftaware.mapper.ClientConverter;
import ma.maisonSoftware.maisonSoftaware.mapper.ClientVo;
import ma.maisonSoftware.maisonSoftaware.model.Client;
import ma.maisonSoftware.maisonSoftaware.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Clients")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    IClientService iClientService;
    /*@GetMapping(value = "/admin/client", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<ClientVo> getAllClient()
    {
        return iClientService.getAllClient();
    }
*/


    @GetMapping("/admin/client")
    public ResponseEntity<List<Client>> getClientsWithAndWithoutPrestations() {
        List<Client> clients = iClientService.getAllClientsWithAndWithoutPrestations();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @GetMapping(value = "/client/{id}")
    public ResponseEntity<Object> getclientByid(@PathVariable(value = "id") Long clientVoId) {
        ClientVo clientVoFound = iClientService.getClientById(clientVoId);
        if (clientVoFound == null)
            return new ResponseEntity<>("client doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(clientVoFound, HttpStatus.OK);
    }
    @PostMapping(value = "/admin/createClient")
    public ResponseEntity<Object> createClient(@Valid @RequestBody ClientVo clientVo) {
        try {
            logger.info("Received client data: {}", clientVo);
            iClientService.save(clientVo);
            return new ResponseEntity<>("Client created successfully", HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("Failed to create client: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/admin/updateSociete/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable(name = "id") Long clientid,@Valid @RequestBody ClientVo clientVo) {
        ClientVo clientFound = iClientService.getClientById(clientid);
        if (clientFound == null)
            return new ResponseEntity<>("Client doen't exist", HttpStatus.OK);
        clientVo.setId(clientid);
        iClientService.save(clientVo);
        return ResponseEntity.ok().body(new ApiResponse());
    }

    @DeleteMapping(value = "/admin/deleteclient/{id}")
    public ResponseEntity<Object> deleteclient(@PathVariable(name = "id") Long  clientvoid) {
        ClientVo clientFound = iClientService.getClientById(clientvoid);
        if (clientFound == null) {
            return ResponseEntity.badRequest().body(new ApiResponse());
        }
        iClientService.delete(clientvoid);
        return ResponseEntity.ok().body(new ApiResponse());
    }



    @GetMapping(value = "/admin/client/rs/{rs}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSocieteByName(@PathVariable(value = "rs") String nameSociete) {
        ClientVo societeNameFound =  iClientService.findByRs(nameSociete);
        if (societeNameFound == null)
            return new ResponseEntity<>("societe name doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeNameFound, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/client/cnss/{cnss}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSocieteByCnss(@PathVariable(value = "cnss") long cnssSociete) {
        ClientVo societeRcFound =  iClientService.findByCnss(cnssSociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("societe cnss doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }
    @GetMapping(value = "/admin/client/ice/{ice}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSocieteByIce(@PathVariable(value = "ice") long iceSociete) {
        ClientVo societeRcFound =  iClientService.findByIce(iceSociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("societe ice doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }
    @GetMapping(value = "/admin/client/ip/{ip}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByIp(@PathVariable(value = "ip") long ipSociete) {
        ClientVo societeRcFound =  iClientService.findByIp(ipSociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("societe ip doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }
    @GetMapping(value = "/admin/client/propriete/{propriete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByPropriete(@PathVariable(value = "propriete") String proprieteSociete) {
        ClientVo societeRcFound =  iClientService.findByPropriete(proprieteSociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("societe proprieteS doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/client/ctNum/{ctNum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByCtNum(@PathVariable(value = "ctNum") String ctNumSociete) {
        ClientVo societeRcFound =  iClientService.findByCtNum(ctNumSociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("societe ctNum doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }

   /* @GetMapping(value = "/admin/client/i_f/{i_f}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSocieteByIf(@PathVariable(value = "i_f") long i_fSociete) {
        ClientVo societeRcFound =  iClientService.findByIf(i_fSociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("Societe i_f doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }*/







    @GetMapping(value = "/admin/client/typesociete/{typesociete}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBytypesociete(@PathVariable(value = "typesociete") String typesociete) {
        ClientVo societeRcFound =  iClientService.findBytypesociete(typesociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("societe typesociete doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/client/forme/{forme}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByforme(@PathVariable(value = "forme") String formesociete) {
        ClientVo societeRcFound =  iClientService.findByForme(formesociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("societe forme doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }
    @GetMapping(value = "/admin/client/capitale/{capitale}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBycapitale(@PathVariable(value = "capitale") String capitalesociete) {
        ClientVo societeRcFound =  iClientService.findByCapitale(capitalesociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("societe capitale doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }
    @GetMapping(value = "/admin/client/siege/{siege}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBysiege(@PathVariable(value = "siege") String siegesociete) {
        ClientVo societeRcFound =  iClientService.findBySiege(siegesociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("societe siegesociete doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }
    @GetMapping(value = "/admin/client/rc/{rc}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  getByrc(@PathVariable(value = "rc") long rcSociete) {
        ClientVo societeRcFound =  iClientService.findByRc(rcSociete);
        if (societeRcFound == null)
            return new ResponseEntity<>("societe rc doen't exist", HttpStatus.OK);
        return new ResponseEntity<>(societeRcFound, HttpStatus.OK);
    }


    @PutMapping("/admin/client/update/{id_client}/{id}")
    public ResponseEntity<Object> associateSocietePrestation(@PathVariable(name = "id_client") Long idClient,
            @PathVariable(name = "id") Long idPrestation, @Valid @RequestBody ClientVo clientVo
    ) {
        try {
            String result = iClientService.associateSocietePrestation(idClient, idPrestation);
            return ResponseEntity.ok().body(new ApiResponse());
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Client or Prestation not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while updating the association", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
