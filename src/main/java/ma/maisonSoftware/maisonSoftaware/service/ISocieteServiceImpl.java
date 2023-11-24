package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.dao.ManagerRepository;
import ma.maisonSoftware.maisonSoftaware.dao.SocieteRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.EtapeConverter;
import ma.maisonSoftware.maisonSoftaware.mapper.ManagerConverter;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteConverter;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.model.Etape;
import ma.maisonSoftware.maisonSoftaware.model.Manager;
import ma.maisonSoftware.maisonSoftaware.model.Prestation;
import ma.maisonSoftware.maisonSoftaware.model.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ISocieteServiceImpl implements ISocieteService {
    @Autowired
    SocieteRepository societeRepository;
    @Autowired
    ManagerRepository managerRepository;
    @Override
    public List<SocieteVo> getAllSociete() {
        List<Societe> getSocietes = societeRepository.findAll();
        return SocieteConverter.toListVo(getSocietes);
    }

    @Override
    public void save(SocieteVo societeVo) {

        Societe societe=  societeRepository.save(SocieteConverter.toBo(societeVo));
        SocieteConverter.toBo(societeVo).getManagers().forEach((a)->{
            a.setSociete(societe);

            managerRepository.save(a);
        });
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