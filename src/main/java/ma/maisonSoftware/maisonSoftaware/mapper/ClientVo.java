package ma.maisonSoftware.maisonSoftaware.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.maisonSoftware.maisonSoftaware.model.Manager;

import javax.persistence.*;
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

    private String CtNum;

    private String Intitule;

//    private String Type;

    private String Qualite;

    private String Contact;

    private String Adresse;

    private String Complement;

    private String CodePostal;

    private String Ville;

    private String CodeRegion;

    private String Pays;

    private String Telephone;

    private String Telecopie;

    private String EMail;

    private String Site;

//    private String Coface;

    private String Facebook;
    private String LinkedIn;

    private String cmt;

    private String etat;

    private String typesociete;
    private  AttachmentVo attachment;

}
