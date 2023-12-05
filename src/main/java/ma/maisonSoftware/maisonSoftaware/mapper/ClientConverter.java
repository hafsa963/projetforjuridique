package ma.maisonSoftware.maisonSoftaware.mapper;

import ma.maisonSoftware.maisonSoftaware.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientConverter {
    public static ClientVo toVo(Client client) {
        if (client == null) {
            return null;
        }

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
        clientVo.setComplement(client.getComplement());
        clientVo.setCtNum(client.getCtNum());
        clientVo.setCodepostal(client.getCodepostal());
        clientVo.setCoderegion(client.getCoderegion());
        clientVo.setEmail(client.getEmail());
        clientVo.setQualite(client.getQualite());
        clientVo.setTel(client.getTel());
        clientVo.setTelcopie(client.getTelcopie());
        clientVo.setVille(client.getVille());
        clientVo.setPays(client.getPays());
        clientVo.setTypesociete(client.getTypesociete());
        clientVo.setEtat(client.getEtat());
        clientVo.setAttachment(AttachmentConverter.toVoList(client.getAttachmentEntity()));

        return clientVo;
    }

    public static Client toBo(ClientVo clientVo) {
        if (clientVo == null) {
            return null; // or throw an exception, depending on your requirements
        }

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
        clientBo.setComplement(clientVo.getComplement());
        clientBo.setCtNum(clientVo.getCtNum());
        clientBo.setCodepostal(clientVo.getCodepostal());
        clientBo.setCoderegion(clientVo.getCoderegion());
        clientBo.setEmail(clientVo.getEmail());
        clientBo.setQualite(clientVo.getQualite());
        clientBo.setTel(clientVo.getTel());
        clientBo.setTelcopie(clientVo.getTelcopie());
        clientBo.setVille(clientVo.getVille());
        clientBo.setPays(clientVo.getPays());
        clientBo.setTypesociete(clientVo.getTypesociete());
        clientBo.setEtat(clientVo.getEtat());
        clientBo.setAttachmentEntity(AttachmentConverter.toBoList(clientVo.attachment));

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
