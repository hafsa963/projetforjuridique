package ma.maisonSoftware.maisonSoftaware.mapper;

import ma.maisonSoftware.maisonSoftaware.model.Societe;

import java.util.ArrayList;
import java.util.List;

public class SocieteConverter {
    public static SocieteVo toVo(Societe societe){
         SocieteVo societeVo = new SocieteVo();
         societeVo.setId(societe.getId());
         societeVo.setNom(societe.getNom());
         societeVo.setForme(societe.getForme());
         societeVo.setCapitale(societe.getCapitale());
         societeVo.setSiege(societe.getSiege());
         societeVo.setRc(societe.getRc());
         societeVo.setI_f(societe.getI_f());
         societeVo.setIce(societe.getIce());
         societeVo.setIp(societe.getIp());
         societeVo.setCnss(societe.getCnss());
         societeVo.setPropriete(societe.getPropriete());
         return societeVo;
    }
     public static Societe toBo(SocieteVo societeVo){
          Societe toBo = new Societe();
          toBo.setId(societeVo.getId());
          toBo.setNom(societeVo.getNom());
          toBo.setForme(societeVo.getForme());
          toBo.setCapitale(societeVo.getCapitale());
          toBo.setSiege(societeVo.getSiege());
          toBo.setRc(societeVo.getRc());
          toBo.setI_f(societeVo.getI_f());
          toBo.setIce(societeVo.getIce());
          toBo.setIp(societeVo.getIp());
          toBo.setCnss(societeVo.getCnss());
          toBo.setPropriete(societeVo.getPropriete());
          return toBo;
     }
     public static List<SocieteVo> toListVo(List<Societe> listBo) {
          List<SocieteVo> listVo = new ArrayList<>();
          for (Societe societe : listBo) {
               listVo.add(toVo(societe));
          }
          return listVo;
     }
}
