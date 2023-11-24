package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.mapper.AttachmentVo;
import ma.maisonSoftware.maisonSoftaware.model.AttachmentEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AttachmentService {
    AttachmentVo uploadfile(Long id,MultipartFile file) throws IOException;
    byte[] downloadFile(String fileName) throws IOException;

}
