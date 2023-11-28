package ma.maisonSoftware.maisonSoftaware.mapper;

import ma.maisonSoftware.maisonSoftaware.model.Client;
import ma.maisonSoftware.maisonSoftaware.model.TypeSociete;

import java.util.ArrayList;
import java.util.List;

public class TypeSocieteConverter {

    public static TypeSocieteVo toVo(TypeSociete typeSociete) {
        TypeSocieteVo typeSocieteVo = new TypeSocieteVo();
        typeSocieteVo.setId(typeSociete.getId());
        typeSocieteVo.setNom(typeSociete.getNom());

        return typeSocieteVo;
    }
    public static TypeSociete toBo(TypeSocieteVo typeSocieteVo) {
        TypeSociete typeSociete = new TypeSociete();
        typeSociete.setId(typeSocieteVo.getId());
        typeSociete.setNom(typeSocieteVo.getNom());
        return typeSociete;
    }

    public static List<TypeSocieteVo> tovolist(List<TypeSociete> listBo) {
        List<TypeSocieteVo> listVo = new ArrayList<>();
        for(TypeSociete typeSociete : listBo){
            listVo.add(toVo(typeSociete));
        }
        return listVo;
    }
    public static List<TypeSociete> toListBo(List<TypeSocieteVo> listVo) {
        List<TypeSociete> ListBo = new ArrayList<>();
        for(TypeSocieteVo typeSocieteVo : listVo){
            ListBo.add(toBo(typeSocieteVo));
        }
        return ListBo;
    }


}
