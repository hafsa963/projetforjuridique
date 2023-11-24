package ma.maisonSoftware.maisonSoftaware.service;


import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.model.Societe;

import java.util.List;

public interface ISocieteService {
    List<SocieteVo> getAllSociete();
    void save(SocieteVo societeVo);
    SocieteVo getSocieteById(Long id);
    void delete(Long id);
    void deleteManager(Long id);
//    List<SocieteVo> findBySociete(String societe);

    List<SocieteVo> findAll(int pageId, int size);
    List<SocieteVo> sortBy(String fielName);
    SocieteVo findByNom(String name);

    SocieteVo findByRc(Long rc);
    void update(SocieteVo societeVo);
}