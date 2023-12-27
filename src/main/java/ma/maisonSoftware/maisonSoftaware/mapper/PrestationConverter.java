package ma.maisonSoftware.maisonSoftaware.mapper;

import ma.maisonSoftware.maisonSoftaware.model.Prestation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PrestationConverter {


    public static PrestationVo toVo(Prestation bo){
        if (bo == null)
            return null;
        PrestationVo vo = new  PrestationVo();
        vo.setId(bo.getId());
        vo.setNamePrestation(bo.getNamePrestation());
        vo.setEtat(bo.getEtat());
        // vo.setClientList(bo.getClients());
        vo.setClientList(ClientConverter.toVoList(bo.getClients()));

        vo.setEtapeDtoList(EtapeConverter.toVoList(bo.getEtapes()));
        return vo;
    }




    public static Prestation toBo (PrestationVo vo){

        Prestation bo  = new Prestation();
        if (bo == null) {
            return null;
        }
        bo.setId(vo.getId());
        bo.setNamePrestation(vo.getNamePrestation());
        bo.setEtat(vo.getEtat());
        bo.setClients(ClientConverter.toListBo(vo.getClientList()));
        bo.setEtapes(EtapeConverter.toBoList(vo.getEtapeDtoList()));

        return bo;
    }

   public static List<PrestationVo> toVoListPrestation(List<Prestation> boListPrestation) {
        List<PrestationVo> toVoList = new ArrayList<>();
        for (Prestation prestation : boListPrestation){
            toVoList.add(PrestationConverter.toVo(prestation));

        }
        return toVoList;
    }
    public static List<Prestation> toBoListPrestation(List<PrestationVo> toVoListPrestation) {
        List<Prestation> toBoList = new ArrayList<>();
        for (PrestationVo prestationVo : toVoListPrestation) {
            toBoList.add(toBo(prestationVo));
        }
        return toBoList;
    }

}
