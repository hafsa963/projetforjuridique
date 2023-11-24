package ma.maisonSoftware.maisonSoftaware.service;

import lombok.RequiredArgsConstructor;
import ma.maisonSoftware.maisonSoftaware.dao.AttachmentRepository;
import ma.maisonSoftware.maisonSoftaware.dao.SocieteRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.AttachmentConverter;
import ma.maisonSoftware.maisonSoftaware.mapper.AttachmentVo;
import ma.maisonSoftware.maisonSoftaware.mapper.FileManagerUtilis;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.model.AttachmentEntity;
import ma.maisonSoftware.maisonSoftaware.model.Societe;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepository attachmentRepository;
    private final SocieteRepository societeRepository;
    private final FilesUploadService filesUploadService;


    @Override
    public AttachmentVo uploadfile(Long id, MultipartFile file) throws IOException {
        Societe societe = societeRepository.getById(id);
        String folderName = societe.getId() + "-files";
        filesUploadService.uploadFile(file, folderName);
        AttachmentVo attachmentVo = new AttachmentVo();
        attachmentVo.setName(file.getOriginalFilename());
        attachmentVo.setImagePath(folderName + "/" + file.getOriginalFilename());
        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String mimeType = (!StringUtils.isEmpty(FileManagerUtilis.mimetypes.get(fileExt))) ? FileManagerUtilis.mimetypes.get(fileExt) : "application/octet-stream";
        attachmentVo.setType(mimeType);
        AttachmentEntity attachment = attachmentRepository.save(AttachmentConverter.toBo(attachmentVo));
        societe.setAttachmentEntity(attachment);
       societeRepository.save(societe);
        return AttachmentConverter.toVo(attachment);
    }

    @Override
    public byte[] downloadFile(String fileName) throws IOException {
        Optional<AttachmentEntity> fileObject = attachmentRepository.findByName(fileName);
        String fullPath = fileObject.get().getImagePath();
        return filesUploadService.download(fullPath);
    }




}
