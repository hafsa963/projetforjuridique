package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.mapper.ClientVo;
import ma.maisonSoftware.maisonSoftaware.mapper.ManagerVo;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
import ma.maisonSoftware.maisonSoftaware.model.Client;

import java.util.List;

public interface IClientService {

    void save(ClientVo clientVo);


    //List<ClientVo> getAllClients();

    //List<Client> getAllClientsWithAndWithoutPrestations(int offset, int pageSize);

    ClientVo getClientById(Long id);
    void delete(Long id);
    ClientVo findByRaisonsociale(String rs);

    void updateClient(Long clientId);

    ClientVo findByRs(String rs);

    ClientVo findByRc(Long rc);
    void update(ClientVo clientVo);

    ClientVo findByCnss(Long cnss);

    ClientVo findByIce(Long ice);

    ClientVo findByIp(Long ip);

    ClientVo findByPropriete(String propriete);
    ClientVo findByCtNum(String ctNum);
    ClientVo findByForme(String forme);

    ClientVo findByCapitale(String capitale);

    ClientVo findBySiege(String siege);
    ClientVo findBytypesociete(String typesociete);

    String associateSocietePrestation(long id_client, long id);

    List<Client> getAllClientsWithAndWithoutPrestations();

    // ClientVo findByIf(Long i_f);

}
