package ma.maisonSoftware.maisonSoftaware.controller.rest;

import ma.maisonSoftware.maisonSoftaware.exception.FileStorageException;
import ma.maisonSoftware.maisonSoftaware.mapper.DataBaseFileVo;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.service.ISocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/societes")
public class SocieteController {
    @Autowired
    ISocieteService iSocieteService;

    @GetMapping(value = "/admin/societe", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PutMapping(value = "/admin/updateSociete/{id}")
    public ResponseEntity<Object> updateSociete(@PathVariable(name = "id") Long societeId, @Valid @RequestBody SocieteVo societeVo) {
        SocieteVo societeVo1Found = iSocieteService.getSocieteById(societeId);
        if (societeVo1Found == null)
            return new ResponseEntity<>("societe doen't exist", HttpStatus.OK);
        societeVo.setId(societeId);
        iSocieteService.save(societeVo);
        return new ResponseEntity<>("Societe is updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/admin/deleteSociete/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteSociete(@PathVariable(name = "id") Long societeVoId) {
        SocieteVo societeVoFound = iSocieteService.getSocieteById(societeVoId);
        if (societeVoFound == null)
            return new ResponseEntity<>("societe doen't exist", HttpStatus.OK);
        iSocieteService.delete(societeVoId);
        return new ResponseEntity<>("Societe is deleted successsfully", HttpStatus.OK);
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

    @GetMapping(value = "/admin/societe/sort/{fieldName}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<SocieteVo> sortBy(@PathVariable String fieldName) {
        return iSocieteService.sortBy(fieldName);
    }

    @DeleteMapping(value = "admin/deleteManager/{id}")
    public ResponseEntity<Object> deleteManager(@PathVariable(name = "id") long managerId) {
        iSocieteService.deleteManager(managerId);
        return new ResponseEntity<>("manager is deleted successsfully", HttpStatus.OK);

//    }
//    @GetMapping("/downloadFile/{id}")
//    public ResponseEntity<Resource> downloadDiplome(@PathVariable Long id) {
//        SocieteVo societevo = iSocieteService.getSocieteById(id);
//        DataBaseFileVo file = societevo.getFile();
//
//        return ResponseEntity.ok().contentType(MediaType.parseMediaType(file.getFileType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
//                .body(new ByteArrayResource(file.getData()));
//    }
//
//    @PostMapping(value = "/files", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> create(@RequestPart("societe") SocieteVo societeVo,@RequestPart("file") MultipartFile file) {
//        // Normalize file name
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        try {
//            // Check if the file's name contains invalid characters
//            if (fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//            }
//            societeVo.setFile(new DataBaseFileVo(fileName, file.getContentType(), file.getBytes()));
//            iSocieteService.save(societeVo);
//        } catch (IOException ex) {
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
//        }
//        return new ResponseEntity<String>("societe created with success", HttpStatus.CREATED);
//    }

//    @PutMapping(value = "/file/{id}", produces = MediaType.APPLICATION_JSON_VALUE
//         )
//    public ResponseEntity<String> update(@PathVariable(value = "id") Long id, @RequestBody SocieteVo societeVo,
//                                         @RequestParam("file") MultipartFile file) {
//        societeVo.setId(id);
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        try {
//            if (fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//            }
//            societeVo.setFile(new DataBaseFileVo(fileName, file.getContentType(), file.getBytes()));
//            iSocieteService.save(societeVo);
//        } catch (IOException ex) {
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
//        }
//        return new ResponseEntity<String>("Employee updated with success", HttpStatus.OK);
//    }


    }
}
