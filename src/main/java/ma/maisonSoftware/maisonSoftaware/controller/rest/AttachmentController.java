package ma.maisonSoftware.maisonSoftaware.controller.rest;

import ma.maisonSoftware.maisonSoftaware.dao.AttachmentRepository;
import ma.maisonSoftware.maisonSoftaware.exception.BusinessException;
import ma.maisonSoftware.maisonSoftaware.model.AttachmentEntity;
import ma.maisonSoftware.maisonSoftaware.service.AttachmentService;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attachment")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private AttachmentRepository attachmentRepository;


    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/upload/{id}")
    public ResponseEntity<String> uploadFile(@PathVariable Long id, @RequestPart("file") MultipartFile[] file) {
        try {
            attachmentService.uploadFile(id, file[0]);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }


    @GetMapping("/download/{fileId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long fileId) {
        Optional<AttachmentEntity> fileOptional = attachmentService.findById(fileId);

        if (fileOptional.isPresent()) {
            AttachmentEntity attachmentEntity = fileOptional.get();
            byte[] fileContent = attachmentService.downloadFile(fileId);

            if (fileContent != null && fileContent.length > 0) {
                HttpHeaders headers = new HttpHeaders();

                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                String filename = attachmentEntity.getName();
                headers.add("X-File-Type", attachmentEntity.getType());

                headers.setContentDispositionFormData("attachment", filename);

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(fileContent);
            }
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/allFiles")
    List<AttachmentEntity> attachmentEntities() {
        return attachmentService.findAll();
    }



}