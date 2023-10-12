package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.*;
import ma.maisonSoftware.maisonSoftaware.model.Etape;

import java.util.List;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor

public class PrestationVo {

    private long id;

    private String namePrestation;

    @ToString.Exclude
    private List<EtapeVo> etapeDtoList;

    public PrestationVo(String namePrestation) {
        this.namePrestation = namePrestation;
    }

    public PrestationVo(String namePrestation, List<EtapeVo> etapeDtoList) {
        this.namePrestation = namePrestation;
        this.etapeDtoList = etapeDtoList;
    }




}
