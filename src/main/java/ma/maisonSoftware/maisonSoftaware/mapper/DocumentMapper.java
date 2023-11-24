package ma.maisonSoftware.maisonSoftaware.mapper;

import ma.maisonSoftware.maisonSoftaware.model.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocumentMapper {

    public static DocumentDto toDTO(Document entity) {
        DocumentDto dto = new DocumentDto();
        dto.setIdDocument(dto.getIdDocument());
//        dto.setNomDocument(dto.getNomDocument());
        dto.setEtapeDto(EtapeConverter.toDTO((entity.getEtape())));
        return dto;
    }

    public static Document toEntity(DocumentDto dto){
        Document entity = new Document();
        entity.setIdDocument(entity.getIdDocument());
//        entity.setNomDocument(entity.getNomDocument());
        entity.setEtape(EtapeConverter.toEntity((dto.getEtapeDto())));
        return entity;
    }

    public static List<DocumentDto> documentToDtos(List<Document> documents) {
        if(documents!=null&&!documents.isEmpty()){
            return documents.stream().map(document -> toDTO(document)).collect(Collectors.toList());
        }else {
            return new ArrayList<>();
        }
    }
    public static List<Document> documentToEntitys(List<DocumentDto> documents) {
        if(documents!=null&&!documents.isEmpty()){
            return documents.stream().map(document -> toEntity(document)).collect(Collectors.toList());
        }else {
            return new ArrayList<>();
        }
    }


}
