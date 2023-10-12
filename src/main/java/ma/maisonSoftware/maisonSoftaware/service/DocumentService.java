package ma.maisonSoftware.maisonSoftaware.service;


import ma.maisonSoftware.maisonSoftaware.mapper.DocumentDto;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

    void insererDocument(MultipartFile file);

    String updateDocument(DocumentDto dto);

    String deleteById(int idEtape);
}
