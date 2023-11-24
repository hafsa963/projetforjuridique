package ma.maisonSoftware.maisonSoftaware.service;


import ma.maisonSoftware.maisonSoftaware.mapper.ManagerVo;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.model.Societe;

import java.util.List;

public interface ISocieteService {
    List<SocieteVo> getAllSociete();
    void save(SocieteVo societeVo);


    /*    @Override
        public Societe associateSocietePrestation(long id_Societe, long id){

             Societe societe = societeRepository.findById(id_Societe)
                     .orElseThrow(() -> new EntityNotFoundException("Societe not found with id: " + id_Societe));

             Prestation prestation = prestationRepository.findById(id)
                     .orElseThrow(() -> new EntityNotFoundException("prestation not found with id: " + id));


             List <Prestation> prestations = new ArrayList<>();
             prestations.add(prestation);
            societe.setPrestations(prestations);

            societeRepository.save(societe);
             return societe;

        }*/
    String associateSocietePrestation(long id_Societe, long id);

    void save(List<ManagerVo> managerVos, Long societeId);

    SocieteVo getSocieteById(Long id);
    void delete(Long id);
    void deleteManager(Long id);
//    List<SocieteVo> findBySociete(String societe);

    List<SocieteVo> findAll(int pageId, int size);
    List<SocieteVo> sortBy(String fielName);
    SocieteVo findByNom(String name);

    SocieteVo findByRc(Long rc);
    void calculateMandatDurationInYears(ManagerVo managerVo);
    void update(SocieteVo societeVo);
}
