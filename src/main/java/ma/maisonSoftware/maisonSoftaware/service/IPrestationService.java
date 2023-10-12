package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.mapper.PrestationVo;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.model.Prestation;

import java.util.List;


public interface IPrestationService {

    List<PrestationVo> getAllPrestation();
    void save(PrestationVo vo);
    PrestationVo getPestationById(Long id);

    void deleteEtape(Integer id);

    void delete(Long id);
     void update(PrestationVo vo);

    List<PrestationVo> findAll(int pageId, int size);
    List<PrestationVo> sortBy(String fielName);




}
