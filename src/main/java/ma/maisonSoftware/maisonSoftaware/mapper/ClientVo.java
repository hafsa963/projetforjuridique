package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.maisonSoftware.maisonSoftaware.model.Client;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientVo {

    private Long id;

    private String rs;

    private String forme;

    private String capitale;

    private String siege;

    private Long rc;

    private Long i_f;

    private Long ice;

    private Long ip;

    private Long cnss;

    private String propriete;

    private String ctNum;


    private String qualite;

    private String adresse;

    private String complement;

    private String codepostal;


    private String ville;

    private String coderegion;

    private String pays;

    private String tel;

    private String telcopie;

    private String email;

    private String cmt;

    private String etat;

    private String typesociete;

    List<AttachmentVo> attachment;
    List<PrestationVo>  prestationList = new ArrayList<>();


    public ClientVo(String rs, String forme, String capitale, String siege, Long rc, Long i_f, Long ice, Long ip, Long cnss, String propriete, String ctNum, String qualite, String adresse, String complement, String codepostal, String ville, String coderegion, String pays, String tel, String telcopie, String email, String cmt, String etat, String typesociete) {
        this.rs = rs;
        this.forme = forme;
        this.capitale = capitale;
        this.siege = siege;
        this.rc = rc;
        this.i_f = i_f;
        this.ice = ice;
        this.ip = ip;
        this.cnss = cnss;
        this.propriete = propriete;
        this.ctNum = ctNum;
        this.qualite = qualite;
        this.adresse = adresse;
        this.complement = complement;
        this.codepostal = codepostal;
        this.ville = ville;
        this.coderegion = coderegion;
        this.pays = pays;
        this.tel = tel;
        this.telcopie = telcopie;
        this.email = email;
        this.cmt = cmt;
        this.etat = etat;
        this.typesociete = typesociete;

    }


}

    /*   this.attachment = attachment;
        this.prestationList = prestationList;*/