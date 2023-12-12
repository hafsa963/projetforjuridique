package ma.maisonSoftware.maisonSoftaware.mapper;

import ma.maisonSoftware.maisonSoftaware.model.Prestation;

import java.util.ArrayList;
import java.util.List;

public class PrestationsomaireConverter {

    public static PrestationsomaireVo toVo(Prestation bo){
        if (bo == null)
            return null;
        PrestationsomaireVo vo = new  PrestationsomaireVo();
        vo.setId(bo.getId());
        vo.setNamePrestation(bo.getNamePrestation());
        vo.setEtat(bo.getEtat());
        vo.setEtapeDtoList(EtapeConverter.toVoList(bo.getEtapes()));
        return vo;
    }

    public static Prestation toBo (PrestationsomaireVo vo){

        Prestation bo  = new Prestation();
        if (bo == null) {
            return null;
        }
        bo.setId(vo.getId());
        bo.setNamePrestation(vo.getNamePrestation());
        bo.setEtat(vo.getEtat());
        bo.setEtapes(EtapeConverter.toBoList(vo.getEtapeDtoList()));

        return bo;
    }

    public static List<PrestationsomaireVo> toVoListPrestation(List<Prestation> boListPrestation) {
        List<PrestationsomaireVo> toVoList = new ArrayList<>();
        for (Prestation prestation : boListPrestation){
            toVoList.add(PrestationsomaireConverter.toVo(prestation));

        }
        return toVoList;
    }
    public static List<Prestation> toBoListPrestation(List<PrestationsomaireVo> toVoListPrestation) {
        List<Prestation> toBoList = new ArrayList<>();
        for (PrestationsomaireVo prestationsomaireVo : toVoListPrestation) {
            toBoList.add(PrestationsomaireConverter.toBo(prestationsomaireVo));
        }
        return toBoList;
    }
}
