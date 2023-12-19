package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.dao.AttachmentRepository;
import ma.maisonSoftware.maisonSoftaware.dao.ClientRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.AttachmentConverter;
import ma.maisonSoftware.maisonSoftaware.mapper.AttachmentVo;
import ma.maisonSoftware.maisonSoftaware.mapper.FileManagerUtilis;
import ma.maisonSoftware.maisonSoftaware.model.AttachmentEntity;
import ma.maisonSoftware.maisonSoftaware.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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

/*    @Override

    public AttachmentVo uploadFile(Long id, MultipartFile file) {
        Client client = clientRepository.getById(id);
        String folderName = client.getId() + "-files";
        filesUploadService.uploadFile(file, folderName);
        AttachmentVo attachmentVo = new AttachmentVo();
        attachmentVo.setName(file.getOriginalFilename());
        attachmentVo.setImagePath(folderName + "/" + file.getOriginalFilename());
        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String mimeType = (!StringUtils.isEmpty(FileManagerUtilis.mimetypes.get(fileExt))) ? FileManagerUtilis.mimetypes.get(fileExt) : "application/octet-stream";
        attachmentVo.setType(mimeType);
        AttachmentEntity attachment = attachmentRepository.save(AttachmentConverter.toBo(attachmentVo));
        //client.setAttachmentEntity(attachment);
        clientRepository.save(client);
        return AttachmentConverter.toVo(attachment);
    }*/

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

            AttachmentEntity savedAttachment = attachmentRepository.save(attachment);

            return AttachmentConverter.toVo(savedAttachment);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error uploading file", e);
        }

    }

    public byte[] downloadFile(Long fileId) {
        Optional<AttachmentEntity> fileOptional = attachmentRepository.findById(fileId);

        if (fileOptional.isPresent()) {
            AttachmentEntity fileEntity = fileOptional.get();

            try (InputStream inputStream = Files.newInputStream(Paths.get("src\\main\\resources",fileEntity.getImagePath()));
                 ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {

                byte[] data = new byte[1024];
                int nRead;

                while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }

                return buffer.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new byte[0];
    }

    @Override
    public Optional<AttachmentEntity> findById(Long id) {
        return attachmentRepository.findById(id);
    }

    @Override
    public List<AttachmentEntity> findAll() {
        return attachmentRepository.findAll();
    }


}
