package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class EtapeVo {

    private int idEtape;

    private String nomEtape;

    public EtapeVo(int idEtape, String nomEtape) {
        this.idEtape = idEtape;
        this.nomEtape = nomEtape;
    }


    //private List<DocumentDto> documentDto;
//

//
//    public EtapeDto() {
//    }
//
//    public int getIdEtape() {
//        return idEtape;
//    }
//
//    public void setIdEtape(int idEtape) {
//        this.idEtape = idEtape;
//    }
//
//    public String getNomEtape() {
//        return nomEtape;
//    }
//
//    public void setNomEtape(String nomEtape) {
//        this.nomEtape = nomEtape;
//    }
//
//    public PrestationVo getPrestationVo() {
//        return prestation;
//    }
//
//    public void setPrestationVo(PrestationVo prestation) {
//        this.prestation = prestation;
//    }
//
//    /*public List<DocumentDto> getDocumentDto() {
//        return documentDto;
//    }
//
//    public void setDocumentDto(List<DocumentDto> documentDto) {
//        this.documentDto = documentDto;
//    }*/
//
//    @Override
//    public String toString() {
//        return "EtapeDto{" +
//                "idEtape=" + idEtape +
//                ", nomEtape='" + nomEtape + '\'' +
//                ", prestationVo=" + prestation +
//                //", documentDto=" + documentDto +
//                '}';
//    }
}
