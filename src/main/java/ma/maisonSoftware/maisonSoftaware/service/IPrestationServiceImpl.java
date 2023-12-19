package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.dao.ClientRepository;
import ma.maisonSoftware.maisonSoftaware.dao.EtapeRepository;
import ma.maisonSoftware.maisonSoftaware.dao.PrestationRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.*;
import ma.maisonSoftware.maisonSoftaware.model.Etape;
import ma.maisonSoftware.maisonSoftaware.model.Prestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service

public class IPrestationServiceImpl implements IPrestationService {
    @Autowired
    PrestationRepository prestationRepository;
    @Autowired
    private EtapeRepository etapeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<PrestationsomaireVo> getAllPrestation() {

        List<Prestation> prestations =   prestationRepository.getAllPrestation();
        List<PrestationsomaireVo> prestations1 =  PrestationsomaireConverter.toVoListPrestation(prestations);
         return  prestations1;
    }



    @Transactional
    @Override
    public void save(PrestationVo vo) {

         Prestation prestation = prestationRepository.save(PrestationConverter.toBo(vo));
        if (prestation.getEtat() == null || prestation.getEtat().trim().isEmpty()) {
            prestation.setEtat("not affected");
        }
        PrestationConverter.toBo(vo).getEtapes().forEach(etape -> {
            etape.setPrestation(prestation);
            etapeRepository.save(etape);
        });

    }

    @Transactional
    @Override
    public void update(PrestationVo vo) {
        Optional<Prestation> optional = prestationRepository.findById(vo.getId());
        if (optional.isPresent()) {
            Prestation prestation = optional.get();
            prestation.setNamePrestation(vo.getNamePrestation());
            prestation.setEtat(vo.getEtat());
            /*prestation.getEtapes().forEach(etape -> {
                if (!vo.getEtapeDtoList().stream().map(EtapeVo::getIdEtape).collect(Collectors.toList()).contains(etape.getIdEtape())){
                  etapeRepository.deleteById(etape.getIdEtape());
                }
            });*/
            vo.getEtapeDtoList().forEach(etape -> {
                Optional<Etape> optionalEtape = etapeRepository.findById(etape.getIdEtape());
                if (optionalEtape.isPresent()) {
                    optionalEtape.get().setNomEtape(etape.getNomEtape());
                    optionalEtape.get().setPrestation(prestation);
                    etapeRepository.save(optionalEtape.get());
                } else {
                    Etape entity = EtapeConverter.toEntity(etape);
                    entity.setPrestation(prestation);
                    etapeRepository.save(entity);
                }
            });
        }

    }




    @Override
    public PrestationVo getPestationById(Long id) {
        boolean trouve = prestationRepository.existsById(id);
        if (!trouve)
            return null;
        return PrestationConverter.toVo(prestationRepository.getById(id));
    }
    @Override
    public void deleteEtape(Integer id) {
        etapeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {

        boolean trouve = prestationRepository.existsById(id);
        if (!trouve) {
            System.out.println("null");
        }
        prestationRepository.deleteById(id);
    }

  /*  @Override
    public List<PrestationVo> findAll(int pageId, int size) {
        Page<Prestation> prestationPage = prestationRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC));
        return PrestationConverter.toVoListPrestation(prestationPage.getContent());
    }*/


    @Override
    public List<PrestationVo> sortBy(String fielName) {
        return PrestationConverter.toVoListPrestation(prestationRepository.findAll(Sort.by(fielName)));
    }



    @Override
    public PrestationVo findByNamePrestation(String namePrestation) {

        Prestation prestation = prestationRepository.findByNamePrestation(namePrestation);
        return PrestationConverter.toVo(prestation);
    }

    @Override
    public PrestationVo findByid(Long id) {

        Prestation prestation = prestationRepository.findByid(id);
        return PrestationConverter.toVo(prestation);
    }

    @Override
    public  PrestationVo getalletapeByPrestation(long id){
        return  PrestationConverter.toVo(prestationRepository.findByid(id));
    }

    @Override
    public List<String> getPrestationsClientByID(long idclient) {
        List<String> prestationsNames = prestationRepository.getPrestationsClientByID(idclient);


        if (prestationsNames == null || prestationsNames.isEmpty()) {

            return Collections.emptyList();
        }

        return prestationsNames;
    }



}
