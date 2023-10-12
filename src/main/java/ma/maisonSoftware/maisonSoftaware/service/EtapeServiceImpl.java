//package ma.maisonSoftware.maisonSoftaware.service;
//
//
//import ma.maisonSoftware.maisonSoftaware.dao.EtapeRepository;
//import ma.maisonSoftware.maisonSoftaware.dao.PrestationRepository;
//import ma.maisonSoftware.maisonSoftaware.mapper.*;
//import ma.maisonSoftware.maisonSoftaware.model.Etape;
//import ma.maisonSoftware.maisonSoftaware.model.Societe;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//@Service
//public class EtapeServiceImpl implements EtapeService {
//    private final static Logger LOGGER = LoggerFactory.getLogger(EtapeServiceImpl.class);
//    @Autowired
//    private EtapeRepository etapeRepository;
//  @Autowired
//  private PrestationRepository prestationRepository;
//    @Transactional
//    @Override
//    public String saveEtape(EtapeVo dto) {
//        LOGGER.debug("start method save");
//     etapeRepository.save(EtapeConverter.toEntity(dto));
//        return "votre etape est creer avec succee";
//    }
//
//
//@Transactional
//
//@Override
//    public String updateEtape(EtapeVo dto) {
//        LOGGER.debug("start method update");
//        etapeRepository.save(EtapeConverter.toEntity(dto));
//        return "votre etape est modifier avec succee";
//    }
//
//    @Override
//    public String deleteById( int idEtape, long idPrestation) {
//        LOGGER.debug("start method delete");
//        Etape etape = etapeRepository.findByIdEtapeAndPrestation_Id(idEtape, idPrestation);
//        if (etape != null) {
//            etapeRepository.delete(etape);
//            return "Votre etape est supprimee avec succes";
//        }
//        return "L'etape n'est pas supprimee";
//    }
//
//    @Override
//    public List<EtapeVo> getEtapeByidService(long id) {
//        LOGGER.debug("start methode get all etapes by id prestation");
//        return EtapeConverter.toVoList(etapeRepository.getEtapeByIdPrestation(id));
//    }
//
//    @Override
//    public List<EtapeVo> getAllEtape() {
//        List<Etape> getAllEtape = etapeRepository.findAll();
//        return EtapeConverter.toVoList(etapeRepository.findAll());
//    }
//}
