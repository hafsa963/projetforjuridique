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


   /* @Override
    public List<SocieteVo> sortBy(String fielName) {
        return SocieteConverter.toListVo(societeRepository.findAll(Sort.by(fielName)));

    }*/

    @Override
    public  ClientVo findByRs(String rs) {
        Client client = clientRepository.findByRs(rs);
        return ClientConverter.toVo(client);
    }

    @Override
    public ClientVo findByRc(Long rc) {
         Client client = clientRepository.findByRc(rc);
        return ClientConverter.toVo(client);
    }

    @Override
     public ClientVo findByCnss(Long cnss) {
        Client client = clientRepository.findByCnss(cnss);
        return ClientConverter.toVo(client);
     }
    @Override
     public ClientVo findByIce(Long ice) {
        Client client = clientRepository.findByIce(ice);
         return ClientConverter.toVo(client);
     }
    @Override
    public ClientVo findByIp(Long ip) {
        Client client = clientRepository.findByIp(ip);
        return ClientConverter.toVo(client);
    }
    @Override
    public ClientVo findByPropriete(String propriete) {
        Client client = clientRepository.findByPropriete(propriete);
        return ClientConverter.toVo(client);
    }
    @Override
    public ClientVo findByCtNum(String ctNum) {
        Client client = clientRepository.findByCtNum(ctNum);
        return ClientConverter.toVo(client);
    }
    @Override
    public ClientVo findByForme(String forme) {
         Client client = clientRepository.findByForme(forme);
         return ClientConverter.toVo(client);
     }
    @Override
     public ClientVo findByCapitale(String capitale) {
         Client client = clientRepository.findByCapitale(capitale);
         return ClientConverter.toVo(client);
     }
     @Override
     public ClientVo findBySiege(String siege) {
         Client client = clientRepository.findBySiege(siege);
         return ClientConverter.toVo(client);
     }
    @Override
    public ClientVo findBytypesociete(String typesociete) {
        Client client = clientRepository.findBytypesociete(typesociete);
        return ClientConverter.toVo(client);
    }

   /* @Override
    public ClientVo findByIf(Long i_f) {
        Client client = clientRepository.findByi_f(i_f);
        return ClientConverter.toVo(client);
    }*/
  /* @Override
   public ClientVo findByIf(Long i_f) {
       Client client = clientRepository.findByI_F(i_f);
       return ClientConverter.toVo(client);
   }*/






}
