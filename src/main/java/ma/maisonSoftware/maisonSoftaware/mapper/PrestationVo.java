package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class PrestationVo {

    private long id;

    private String namePrestation;

    private String Etat;

    @ToString.Exclude
    private List<EtapeVo> etapeDtoList;

    @Getter
    @Setter
    private List<ClientVo> clientList;


    public PrestationVo(String namePrestation) {
        this.namePrestation = namePrestation;
    }

    public PrestationVo( String namePrestation, String etat,List<EtapeVo> etapeDtoList) {
        this.namePrestation = namePrestation;
        this.Etat = etat;
        this.etapeDtoList = etapeDtoList;

    }






  /*  public PrestationVo(String namePrestation, List<EtapeVo> etapeDtoList) {
        this.namePrestation = namePrestation;
        this.etapeDtoList = etapeDtoList;
    }*/




}
