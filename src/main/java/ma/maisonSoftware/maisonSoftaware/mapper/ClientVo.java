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
}
