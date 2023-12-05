package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.dao.ClientRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.ClientConverter;
import ma.maisonSoftware.maisonSoftaware.mapper.ClientVo;
import ma.maisonSoftware.maisonSoftaware.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class IClientServiceImpl  implements IClientService  {

    private static final Logger logger = LoggerFactory.getLogger(IClientServiceImpl.class);

    @Autowired
    ClientRepository clientRepository;


    @Transactional
   @Override
    public void save(ClientVo clientVo) {
        try {
            Client client = ClientConverter.toBo(clientVo);
            Client savedClient = clientRepository.save(client);
        } catch (DataAccessException e) {
            logger.error("An error occurred while saving client", e);
            throw e;
        }
    }

    @Override
    public List<ClientVo> getAllClient() {
        List<Client> getClients = clientRepository.findAll();
        return  ClientConverter.toListVo(clientRepository.findAll());
    }

    @Override
    public ClientVo getClientById(Long id) {
        boolean found = clientRepository.existsById(id);
        if (!found)
            return null;
        return ClientConverter.toVo(clientRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientVo findByRaisonsociale(String rs) {
        return null;
    }

    @Override
    public ClientVo findByRc(Long rc) {
        return null;
    }

    @Override
    public void update(ClientVo clientVo) {
        Optional<Client> optional = clientRepository.findById(clientVo.getId());
        if (optional.isPresent()) {
            Client client = optional.get();

            client.setId(clientVo.getId());
            client.setRs(clientVo.getRs());
            client.setForme(clientVo.getForme());
            client.setCapitale(clientVo.getCapitale());
            client.setSiege(clientVo.getSiege());
            client.setRc(clientVo.getRc());
            client.setI_f(clientVo.getI_f());
            client.setIce(clientVo.getIce());
            client.setIp(clientVo.getIp());
            client.setCnss(clientVo.getCnss());
            client.setPropriete(clientVo.getPropriete());
            client.setCmt(clientVo.getCmt());
            client.setAdresse(clientVo.getAdresse());
            client.setComplement(clientVo.getComplement());
            client.setCtNum(clientVo.getCtNum());
            client.setCodepostal(clientVo.getCodepostal());
            client.setCoderegion(clientVo.getCoderegion());
            client.setEmail(clientVo.getEmail());
            client.setQualite(clientVo.getQualite());
            client.setTel(clientVo.getTel());
            client.setTelcopie(clientVo.getTelcopie());
            client.setVille(clientVo.getVille());
            client.setPays(clientVo.getPays());
            client.setTypesociete(clientVo.getTypesociete());
            client.setEtat(clientVo.getEtat());



        }


    }


}
