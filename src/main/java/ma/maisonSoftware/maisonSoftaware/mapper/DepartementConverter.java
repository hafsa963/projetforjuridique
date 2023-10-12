package ma.maisonSoftware.maisonSoftaware.mapper;

import ma.maisonSoftware.maisonSoftaware.model.Departement;

import java.util.ArrayList;
import java.util.List;

public class DepartementConverter {
    public static DepartementVo toVo(Departement bo){
        if (bo == null)
            return null;
        DepartementVo vo = new DepartementVo();
        vo.setId(bo.getId());
        vo.setNomDepartement(bo.getNomDepartement());
        return vo;
    }
    public static Departement toBo(DepartementVo vo) {
        if (vo == null)
            return null;
        Departement bo = new Departement();
        bo.setId(vo.getId());
        bo.setNomDepartement(vo.getNomDepartement());
        return bo;
    }
    public static List<DepartementVo> toVoList(List<Departement> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<DepartementVo> voList = new ArrayList<>();
        for (Departement departement : boList) {
            voList.add(toVo(departement));
        }
        return voList;
    }
    public static List<Departement> toBoList(List<DepartementVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Departement> boList = new ArrayList<>();
        for (DepartementVo departementVo : voList) {
            boList.add(toBo(departementVo));
        }
        return boList;
    }
}
