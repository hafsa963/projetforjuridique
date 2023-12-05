package ma.maisonSoftware.maisonSoftaware.service;

import lombok.RequiredArgsConstructor;
import ma.maisonSoftware.maisonSoftaware.dao.AttachmentRepository;
import ma.maisonSoftware.maisonSoftaware.dao.ClientRepository;
import ma.maisonSoftware.maisonSoftaware.dao.SocieteRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.AttachmentConverter;
import ma.maisonSoftware.maisonSoftaware.mapper.AttachmentVo;
import ma.maisonSoftware.maisonSoftaware.mapper.FileManagerUtilis;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.model.AttachmentEntity;
import ma.maisonSoftware.maisonSoftaware.model.Client;
import ma.maisonSoftware.maisonSoftaware.model.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private FilesUploadService filesUploadService;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository, ClientRepository clientRepository, FilesUploadService filesUploadService) {
        this.attachmentRepository = attachmentRepository;
        this.clientRepository = clientRepository;
        this.filesUploadService = filesUploadService;
    }

    @Override
    public AttachmentVo uploadFile(Long clientId, MultipartFile file) {
        try {
            Client client = clientRepository.findById(clientId)
                    .orElseGet(() -> {
                        Client newClient = new Client();
                        return clientRepository.save(newClient);
                    });

            String folderName = client.getId() + "-files";
            filesUploadService.uploadFile(file, folderName);

            AttachmentVo attachmentVo = new AttachmentVo();
            attachmentVo.setName(file.getOriginalFilename());
            attachmentVo.setImagePath(folderName + "/" + file.getOriginalFilename());
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            String mimeType = (!StringUtils.isEmpty(FileManagerUtilis.mimetypes.get(fileExt))) ? FileManagerUtilis.mimetypes.get(fileExt) : "application/octet-stream";
            attachmentVo.setType(mimeType);

            AttachmentEntity attachment = new AttachmentEntity();
            attachment.setName(attachmentVo.getName());
            attachment.setType(attachmentVo.getType());
            attachment.setImagePath(attachmentVo.getImagePath());
            attachment.setClients(client);

            // Save the AttachmentEntity, which should cascade to the associated Client
            AttachmentEntity savedAttachment = attachmentRepository.save(attachment);

            return AttachmentConverter.toVo(savedAttachment);
        } catch (Exception e) {
            e.printStackTrace();
            // Log additional information if needed
            throw new RuntimeException("Error uploading file", e);
        }
    }


    @Override
    public byte[] downloadFile(String fileName) throws IOException {
        Optional<AttachmentEntity> fileObject = attachmentRepository.findByName(fileName);
        String fullPath = fileObject.get().getImagePath();
        return filesUploadService.download(fullPath);
    }


}
