package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.*;
import ma.maisonSoftware.maisonSoftaware.model.Etape;
import ma.maisonSoftware.maisonSoftaware.model.Societe;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor

public class PrestationVo {

    private long id;

    private String namePrestation;

    private String Etat;

    @ToString.Exclude
    private List<EtapeVo> etapeDtoList;


    //private Societe societe;


    public PrestationVo(String namePrestation) {
        this.namePrestation = namePrestation;
    }

    public PrestationVo( String namePrestation, String etat, List<EtapeVo> etapeDtoList, Societe societe) {
        this.namePrestation = namePrestation;
        Etat = etat;
        this.etapeDtoList = etapeDtoList;
        //this.societe = societe;
    }





  /*  public PrestationVo(String namePrestation, List<EtapeVo> etapeDtoList) {
        this.namePrestation = namePrestation;
        this.etapeDtoList = etapeDtoList;
    }*/




}
