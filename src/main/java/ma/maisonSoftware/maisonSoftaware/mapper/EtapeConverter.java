package ma.maisonSoftware.maisonSoftaware.mapper;
import lombok.ToString;
import ma.maisonSoftware.maisonSoftaware.model.Etape;

import java.util.ArrayList;
import java.util.List;


public class EtapeConverter {

    public static EtapeVo toDTO(Etape entity) {
        if (entity == null)
            return null;
        EtapeVo dtos = new EtapeVo();
        dtos.setIdEtape(entity.getIdEtape());
        dtos.setNomEtape(entity.getNomEtape());
        //dtos.setPrestationVo(PrestationConverter.toVo(entity.getPrestation()));
        return dtos;
    }

    public static Etape toEntity(EtapeVo dto){
        Etape entity = new Etape();
        entity.setNomEtape(dto.getNomEtape());
//        if(dto.getPrestationVo()!= null){
//            entity.setPrestation(PrestationConverter.toBo(dto.getPrestationVo()));
//        }
        return entity;
    }
    public static List<EtapeVo> toVoList(List<Etape> boList) {
        List<EtapeVo> voList = new ArrayList<>();
        boList.forEach(bo -> voList.add(toDTO(bo)));
        return voList;
    }
    public static List<Etape> toBoList(List<EtapeVo> voList) {
        List<Etape> boList = new ArrayList<>();
        voList.forEach(vo -> boList.add(toEntity(vo)));
        return boList;
    }


}
