package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.mapper.ClientVo;
import ma.maisonSoftware.maisonSoftaware.mapper.ManagerVo;
import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;

import java.util.List;

public interface IClientService {

    void save(ClientVo clientVo);

    List<ClientVo> getAllClient();

    ClientVo getClientById(Long id);
    void delete(Long id);
    ClientVo findByRaisonsociale(String rs);

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

   // ClientVo findByIf(Long i_f);

}
