package ma.maisonSoftware.maisonSoftaware.controller.rest;

import ma.maisonSoftware.maisonSoftaware.mapper.AttachmentVo;
import ma.maisonSoftware.maisonSoftaware.model.AttachmentEntity;
import ma.maisonSoftware.maisonSoftaware.service.AttachmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
public class AttachmentController {
    private AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/upload/{id}")
    public void uploadFile( @PathVariable Long id,@RequestParam("file")MultipartFile file) throws IOException {
        attachmentService.uploadfile(id,file);

    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) throws IOException {
        byte[] image = attachmentService.downloadFile(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
}
