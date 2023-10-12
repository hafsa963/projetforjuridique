package ma.maisonSoftware.maisonSoftaware.mapper;

public class DocumentDto {

    public int idDocument;
    public String nomDocument;

    private EtapeVo etapeDto;

    public DocumentDto(int idDocument, String nomDocument, EtapeVo etapeDto) {
        this.idDocument = idDocument;
        this.nomDocument = nomDocument;
        this.etapeDto = etapeDto;
    }

    public DocumentDto() {
    }

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    public String getNomDocument() {
        return nomDocument;
    }

    public void setNomDocument(String nomDocument) {
        this.nomDocument = nomDocument;
    }

    public EtapeVo getEtapeDto() {
        return etapeDto;
    }

    public void setEtapeDto(EtapeVo etapeDto) {
        this.etapeDto = etapeDto;
    }

    @Override
    public String toString() {
        return "DocumentDto{" +
                "idDocument=" + idDocument +
                ", nomDocument='" + nomDocument + '\'' +
                ", etapeDto=" + etapeDto +
                '}';
    }
}
