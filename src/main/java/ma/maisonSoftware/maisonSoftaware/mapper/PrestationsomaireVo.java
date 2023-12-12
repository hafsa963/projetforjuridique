package ma.maisonSoftware.maisonSoftaware.mapper;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PrestationsomaireVo {

    private long id;

    private String namePrestation;

    private String Etat;

    @ToString.Exclude
    private List<EtapeVo> etapeDtoList;


    public PrestationsomaireVo( String namePrestation, String etat, List<EtapeVo> etapeDtoList) {

        this.namePrestation = namePrestation;
        Etat = etat;
        this.etapeDtoList = etapeDtoList;
    }
}
