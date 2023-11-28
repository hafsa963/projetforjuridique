package ma.maisonSoftware.maisonSoftaware.mapper;

import ma.maisonSoftware.maisonSoftaware.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientConverter {
    public static ClientVo toVo(Client client){
        ClientVo clientVo = new ClientVo();
        clientVo.setId(client.getId());
        clientVo.setRs(client.getRs());
        clientVo.setForme(client.getForme());
        clientVo.setCapitale(client.getCapitale());
        clientVo.setSiege(client.getSiege());
        clientVo.setRc(client.getRc());
        clientVo.setI_f(client.getI_f());
        clientVo.setIce(client.getIce());
        clientVo.setIp(client.getIp());
        clientVo.setCnss(client.getCnss());
        clientVo.setPropriete(client.getPropriete());
        clientVo.setCmt(client.getCmt());
        clientVo.setAdresse(client.getAdresse());
        clientVo.setContact(client.getContact());
        clientVo.setComplement(client.getComplement());
        clientVo.setCtNum(client.getCtNum());
        clientVo.setCodePostal(client.getCodePostal());
        clientVo.setCodeRegion(client.getCodeRegion());
        clientVo.setEMail(client.getEMail());
        clientVo.setFacebook(client.getFacebook());
        clientVo.setSite(client.getSite());
        clientVo.setQualite(client.getQualite());
        clientVo.setTelephone(client.getTelephone());
        clientVo.setTelecopie(client.getTelecopie());
        clientVo.setVille(client.getVille());
        clientVo.setPays(client.getPays());
        clientVo.setIntitule(client.getIntitule());
        clientVo.setLinkedIn(client.getLinkedIn());
        clientVo.setTypesociete(client.getTypesociete());
        clientVo.setEtat(client.getEtat());

//        societeVo.setManagerVoList(ManagerConverter.toVoList(societe.getManagers()));
//        societeVo.setPrestationList(PrestationConverter.toVoListPrestation(societe.getPrestations()));
        return clientVo;
    }


    public static Client toBo(ClientVo clientVo){
       Client clientBo = new Client();
        clientBo.setId(clientVo.getId());
        clientBo.setRs(clientVo.getRs());
        clientBo.setForme(clientVo.getForme());
        clientBo.setCapitale(clientVo.getCapitale());
        clientBo.setSiege(clientVo.getSiege());
        clientBo.setRc(clientVo.getRc());
        clientBo.setI_f(clientVo.getI_f());
        clientBo.setIce(clientVo.getIce());
        clientBo.setIp(clientVo.getIp());
        clientBo.setCnss(clientVo.getCnss());
        clientBo.setPropriete(clientVo.getPropriete());
        clientBo.setCmt(clientVo.getCmt());
        clientBo.setAdresse(clientVo.getAdresse());
        clientBo.setContact(clientVo.getContact());
        clientBo.setComplement(clientVo.getComplement());
        clientBo.setCtNum(clientVo.getCtNum());
        clientBo.setCodePostal(clientVo.getCodePostal());
        clientBo.setCodeRegion(clientVo.getCodeRegion());
        clientBo.setEMail(clientVo.getEMail());
        clientBo.setFacebook(clientVo.getFacebook());
        clientBo.setSite(clientVo.getSite());
        clientBo.setQualite(clientVo.getQualite());
        clientBo.setTelephone(clientVo.getTelephone());
        clientBo.setTelecopie(clientVo.getTelecopie());
        clientBo.setVille(clientVo.getVille());
        clientBo.setPays(clientVo.getPays());
        clientBo.setIntitule(clientVo.getIntitule());
        clientBo.setLinkedIn(clientVo.getLinkedIn());
        clientBo.setTypesociete(clientVo.getTypesociete());
        clientBo.setEtat(clientVo.getEtat());

        return clientBo;
    }

    public static List<ClientVo> toListVo(List<Client> listBo) {
        List<ClientVo> listVo = new ArrayList<>();
        for (Client client : listBo) {
            listVo.add(toVo(client));
        }
        return listVo;
    }
    public static List<Client> toListBo(List<ClientVo> listVo) {
        List<Client> ListBo = new ArrayList<>();
        for (ClientVo clientVo : listVo) {
            ListBo.add(toBo(clientVo));
        }
        return ListBo;
    }




}
