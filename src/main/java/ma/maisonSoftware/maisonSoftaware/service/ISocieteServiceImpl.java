package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.dao.ManagerRepository;
import ma.maisonSoftware.maisonSoftaware.dao.PrestationRepository;
import ma.maisonSoftware.maisonSoftaware.dao.SocieteRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.*;
import ma.maisonSoftware.maisonSoftaware.model.Manager;
import ma.maisonSoftware.maisonSoftaware.model.Prestation;
import ma.maisonSoftware.maisonSoftaware.model.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ISocieteServiceImpl implements ISocieteService {
    @Autowired
    SocieteRepository societeRepository;

    @Autowired
    PrestationRepository prestationRepository;
    @Autowired
    ManagerRepository managerRepository;
    @Override
    public List<SocieteVo> getAllSociete() {
        List<Societe> getSocietes = societeRepository.findAll();
        return SocieteConverter.toListVo(societeRepository.findAll());
    }


    @Override
    public void calculateMandatDurationInYears(ManagerVo managerVo) {
        if (managerVo == null) {
            throw new IllegalArgumentException("ManagerVo cannot be null");
        }

        if (managerVo.getDatedebut() == null || managerVo.getDateFin() == null) {
            throw new IllegalArgumentException("ManagerVo dates must be initialized");
        }

        LocalDate debutLocalDate = managerVo.getDatedebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate finLocalDate = managerVo.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long years = ChronoUnit.YEARS.between(debutLocalDate, finLocalDate);

        String result;
        if (years > 0) {
            result = years + " years";
        } else {
            result = "0";
        }

        managerVo.setMandatGerance(result);
    }



  /* @Override
   public void save(SocieteVo societeVo) {
       Societe societe = societeRepository.save(SocieteConverter.toBo(societeVo));
       for (ManagerVo managerVo : societeVo.getManagerVoList()) {
           calculateMandatDurationInYears(managerVo);
           Manager manager = ManagerConverter.bo(managerVo);
           manager.setSociete(societe);
           managerRepository.save(manager);
       }
   }*/

  /* @Override
    public void save(SocieteVo societeVo) {
        Societe societe = SocieteConverter.toBo(societeVo);
        Societe savedSociete = societeRepository.save(societe);
        List<Manager> managers = new ArrayList<>();
        for (ManagerVo managerVo : societeVo.getManagerVoList()) {
            calculateMandatDurationInYears(managerVo);
            Manager manager = ManagerConverter.bo(managerVo);
            manager.setSociete(savedSociete);
            managers.add(manager);
        }
        managerRepository.saveAll(managers);
    }

   */
  /*@Override
  public void save(SocieteVo societeVo) {
      try {
          Societe societe = SocieteConverter.toBo(societeVo);
          Societe savedSociete = societeRepository.save(societe);
          List<Manager> managers = new ArrayList<>();
          for (ManagerVo managerVo : societeVo.getManagerVoList()) {
              calculateMandatDurationInYears(managerVo);
              Manager manager = ManagerConverter.bo(managerVo);
              manager.setSociete(savedSociete);
              managers.add(manager);
          }
          managerRepository.saveAll(managers);
      } catch (Exception e) {
          // Log the exception and other relevant data
          System.out.println("An error occurred while saving Societe: " + e.getMessage());
          e.printStackTrace();
      }
  }*/

    @Override
    public void save(SocieteVo societeVo) {
        try {
            Societe societe = SocieteConverter.toBo(societeVo);
            societe.setPrestations(null);
            Societe savedSociete = societeRepository.save(societe);


        } catch (Exception e) {
            System.out.println("An error occurred while saving Societe: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public String associateSocietePrestation(long id_Societe, long id) {
        try {
            Societe societe = societeRepository.findById(id_Societe)
                    .orElseThrow(() -> new EntityNotFoundException("Societe not found with id: " + id_Societe));

            Prestation prestation = prestationRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Prestation not found with id: " + id));

            societe.getPrestations().add(prestation);
            prestation.setSociete(societe);

            societeRepository.save(societe);

            return "Societe is updated with Prestation successfully";
        } catch (EntityNotFoundException e) {
            return "Societe or Prestation not found";
        } catch (Exception e) {
            return "An error occurred while updating the association";
        }
    }




    /*  @Override
      public void save(List<ManagerVo> managerVos) {
          try {
              List<Manager> managers = new ArrayList<>();
              for (ManagerVo managerVo : managerVos) {
                  calculateMandatDurationInYears(managerVo);
                  Manager manager = ManagerConverter.bo(managerVo);
                  managers.add(manager);
              }
              managerRepository.saveAll(managers);
          } catch (Exception e) {
              // Log the exception and other relevant data
              System.out.println("An error occurred while saving Manager: " + e.getMessage());
              e.printStackTrace();
          }
      }*/
    @Override
    public void save(List<ManagerVo> managerVos, Long societeId) {
        try {
            Societe societe = societeRepository.findById(societeId).get(); // Fetch the Societe object using the provided societeId
            List<Manager> managers = new ArrayList<>();
            for (ManagerVo managerVo : managerVos) {
                calculateMandatDurationInYears(managerVo);
                Manager manager = ManagerConverter.bo(managerVo);
                manager.setSociete(societe); // Set the societe for each manager
                managers.add(manager);
            }
            managerRepository.saveAll(managers);
        } catch (Exception e) {
            // Log the exception and other relevant data
            System.out.println("An error occurred while saving Manager: " + e.getMessage());
            e.printStackTrace();
        }
    }






    @Override
    public SocieteVo getSocieteById(Long id) {
        boolean trouve = societeRepository.existsById(id);
        if (!trouve)
            return null;
        return SocieteConverter.toVo(societeRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        societeRepository.deleteById(id);

    }

    @Override
    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }


    @Override
    public List<SocieteVo> findAll(int pageId, int size) {
        Page<Societe> societePage = societeRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC));
        return SocieteConverter.toListVo(societePage.getContent());

    }

    @Override
    public List<SocieteVo> sortBy(String fielName) {
        return SocieteConverter.toListVo(societeRepository.findAll(Sort.by(fielName)));

    }

    @Override
    public SocieteVo findByNom(String name) {
        Societe societe = societeRepository.findByNom(name);
        return SocieteConverter.toVo(societe);
    }

    @Override
    public SocieteVo findByRc(Long rc) {
        Societe societe = societeRepository.findByRc(rc);
        return SocieteConverter.toVo(societe);
    }


    @Override
    public void update(SocieteVo societeVo) {
        Optional<Societe> optional = societeRepository.findById(societeVo.getId());
        if (optional.isPresent()) {
            Societe societe = optional.get();
            societe.setNom(societeVo.getNom());
            societe.setPropriete(societe.getPropriete());
            societe.setIp(societeVo.getIp());
            societe.setCnss(societeVo.getCnss());
            societe.setCapitale(societeVo.getCapitale());
            societe.setForme(societe.getForme());
            societe.setI_f(societeVo.getI_f());
            societe.setSiege(societeVo.getSiege());
            societe.setIce(societeVo.getIce());
            societeVo.getManagerVoList().forEach(manager->{
                Optional<Manager> optionalManager = managerRepository.findById(manager.getId());
                if(optionalManager.isPresent()){
                    optionalManager.get().setNameManager(manager.getNameManager());
                    optionalManager.get().setSociete(societe);
                    managerRepository.save(optionalManager.get());
                }else {
                    Manager managerEnity = ManagerConverter.bo(manager);
                    managerEnity.setSociete(societe);
                    managerRepository.save(managerEnity);
                }
            });

        }

    }
}