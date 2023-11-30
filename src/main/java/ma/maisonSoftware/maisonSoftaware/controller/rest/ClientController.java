package ma.maisonSoftware.maisonSoftaware.controller.rest;


import io.swagger.v3.oas.models.responses.ApiResponse;
import ma.maisonSoftware.maisonSoftaware.mapper.ClientVo;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Clients")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    IClientService iClientService;
    @GetMapping(value = "/admin/client", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<ClientVo> getAllClient()
    {
        return iClientService.getAllClient();
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
}
