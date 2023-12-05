package ma.maisonSoftware.maisonSoftaware.controller.rest;

import ma.maisonSoftware.maisonSoftaware.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/attachment")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;


    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/upload/{id}")
    public void uploadFile(@PathVariable Long id, @RequestPart("file") MultipartFile[] file) {
        attachmentService.uploadFile(id, file[0]);

    }


    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) throws IOException {
        byte[] image = attachmentService.downloadFile(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }

}
