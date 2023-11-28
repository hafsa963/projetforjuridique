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
    ClientVo findByRc(Long rc);
    void update(ClientVo clientVo);

}
