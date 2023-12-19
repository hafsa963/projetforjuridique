package ma.maisonSoftware.maisonSoftaware.mapper;

import ma.maisonSoftware.maisonSoftaware.model.Manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerConverter {
    public static ManagerVo vo (Manager bo) {
        ManagerVo managerVo = new ManagerVo();
        managerVo.setId(bo.getId());
        managerVo.setNameManager(bo.getNameManager());
        managerVo.setDatedebut(bo.getDatedebut());
        managerVo.setDateFin(bo.getDateFin());
        managerVo.setMandatGerance(bo.getMandatGerance());
        managerVo.setClient(bo.getClient());


//        managerVo.setSocieteVo(SocieteConverter.toVo(bo.getSociete()));
        return managerVo;
      }

      public static Manager bo (ManagerVo vo){
        Manager manager = new Manager();
        manager.setNameManager(vo.getNameManager());
          manager.setDatedebut(vo.getDatedebut());
          manager.setDateFin(vo.getDateFin());
          manager.setMandatGerance(vo.getMandatGerance());
          manager.setClient(vo.getClient());

//        manager.setSociete(SocieteConverter.toBo(vo.getSocieteVo()));
        return manager;
       }

       public static List<ManagerVo> toVoList (List<Manager> boList) {
         List<ManagerVo> voList = new ArrayList<>();
         for (Manager manager:boList) {
             voList.add(vo(manager));
         }
        return voList;
       }

       public static List<Manager> toBoList(List<ManagerVo> voList) {
        List<Manager> managers = new ArrayList<>();
        for (ManagerVo managerVo:voList)    {
            managers.add(bo(managerVo));
        }
        return managers;
       }


}
