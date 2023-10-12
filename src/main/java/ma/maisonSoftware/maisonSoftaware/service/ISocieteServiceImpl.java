package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.dao.SocieteRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteConverter;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.model.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class ISocieteServiceImpl implements ISocieteService {
    @Autowired
    SocieteRepository societeRepository;
    @Override
    public List<SocieteVo> getAllSociete() {
        List<Societe> getSocietes = societeRepository.findAll();
        return SocieteConverter.toListVo(societeRepository.findAll());
    }

    @Override
    public void save(SocieteVo societeVo) {
     societeRepository.save(SocieteConverter.toBo(societeVo));
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

//    @Override
//    public List<SocieteVo> findBySociete(String societe) {
//      List<Societe> societes = societeRepository.findBySociete(societe);
//      return SocieteConverter.toListVo(societes);
//    }

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
}
