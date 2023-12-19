package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.dao.ClientRepository;
import ma.maisonSoftware.maisonSoftaware.dao.ManagerRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.ManagerConverter;
import ma.maisonSoftware.maisonSoftaware.mapper.ManagerVo;
import ma.maisonSoftware.maisonSoftaware.model.Client;
import ma.maisonSoftware.maisonSoftaware.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class IManagerServiceImpl implements IManagerService {

    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    ClientRepository clientRepository;

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
        long months = ChronoUnit.MONTHS.between(debutLocalDate, finLocalDate);

        String result;
        if (years > 0) {
            result = years + " years";
        }
        else if (months > 0) {
            result = months + " months";
        }
         else {
            result = "0";
        }

        managerVo.setMandatGerance(result);
    }

   @Override
   public void save(ManagerVo managerVo) {
       calculateMandatDurationInYears(managerVo);
       Manager manager = ManagerConverter.bo(managerVo);

       manager.setClient(clientRepository.findById(managerVo.getId()).orElse(null));

       managerRepository.save(manager);
   }
    @Override
    public void update(ManagerVo managerVo) {
        calculateMandatDurationInYears(managerVo);

        Optional<Manager> optionalManager = managerRepository.findById(managerVo.getId());

        if (optionalManager.isPresent()) {
            Manager managerToUpdate = optionalManager.get();

            managerToUpdate.setNameManager(managerVo.getNameManager());
            managerToUpdate.setDatedebut(managerVo.getDatedebut());
            managerToUpdate.setDateFin(managerVo.getDateFin());

            managerRepository.save(managerToUpdate);
        } else {

            throw new EntityNotFoundException("Manager with ID " + managerVo.getId() + " not found");
        }
    }


    @Override
    public List<ManagerVo>getAllManager() {
        List<Manager> getAllManager = managerRepository.findAll();
        return   ManagerConverter.toVoList(managerRepository.findAll());


    }

    @Override
    public List<ManagerVo>findAllMangers() {

        List<Manager> allManagers = managerRepository.findAllMangers();
        return ManagerConverter.toVoList(allManagers);

    }

}
