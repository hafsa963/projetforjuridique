package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.dao.PrestationRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.EtapeVo;
import ma.maisonSoftware.maisonSoftaware.mapper.PrestationVo;
import ma.maisonSoftware.maisonSoftaware.mapper.PrestationsomaireVo;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.model.Prestation;

import java.util.List;


public interface IPrestationService {

     void save(PrestationVo vo);
    PrestationVo getPestationById(Long id);

    void deleteEtape(Integer id);

    void delete(Long id);
     void update(PrestationVo vo);

    //List<PrestationVo> findAll(int pageId, int size);
    List<PrestationVo> sortBy(String fielName);
    List<PrestationsomaireVo> getAllPrestation();

    PrestationVo findByNamePrestation(String namePrestation);



    PrestationVo findByid(Long id);


    PrestationVo getalletapeByPrestation(long id);

    List<String>  getPrestationsClientByID(long idclient);

    List<String> findByUniqueRC(long rc);
    List<String> findByRcAndRsAndPropriete(long rc, String rs, String propriete);

    List<String> findByRS(String rs);


    List<String> findByPropriete(String propriete);


    List<EtapeVo> getEtapeByIdPrestation(long id);
}

