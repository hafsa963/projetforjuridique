package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.mapper.AttachmentVo;
import ma.maisonSoftware.maisonSoftaware.model.AttachmentEntity;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface AttachmentService {
    AttachmentVo uploadFile(Long id, MultipartFile file);

    byte[] downloadFile(Long id) ;
    Optional<AttachmentEntity> findById(Long id);

    List<AttachmentEntity> findAll();



}