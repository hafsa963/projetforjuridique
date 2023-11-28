package ma.maisonSoftware.maisonSoftaware.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Client")
    private Long id;

    @Column(name = "Raison_sociale")
    private String rs;

    @Column(name = "forme_Societe")
    private String forme;

    @Column(name = "capitale_Societe")
    private String capitale;

    @Column(name = "seige_Societe")
    private String siege;

    @Column(unique = true, nullable = false, name = "Rc_Societe")
    private Long rc;

    @Column(name = "if_Societe")
    private Long i_f;

    @Column(name = "ice_Societe")
    private Long ice;

    @Column(name = "ip_Societe")
    private Long ip;

    @Column(name = "cnss_Societe")
    private Long cnss;

    @Column(name = "propriete_Societe")
    private String propriete;

    @Column(name = "CtNum", nullable = false)
    private String CtNum;

    @Column(name = "Intitule")
    private String Intitule;

//    @Column(name = "Type")
//    private String Type;

    @Column(name = "Qualite")
    private String Qualite;

    @Column(name = "Contact")
    private String Contact;

    @Column(name = "Adresse")
    private String Adresse;

    @Column(name = "Complement")
    private String Complement;

    @Column(name = "CodePostal")
    private String CodePostal;

    @Column(name = "Ville")
    private String Ville;

    @Column(name = "CodeRegion")
    private String CodeRegion;

    @Column(name = "Pays")
    private String Pays;

    @Column(name = "Telephone")
    private String Telephone;

    @Column(name = "Telecopie")
    private String Telecopie;

    @Column(name = "EMail")
    private String EMail;

    @Column(name = "Site")
    private String Site;

//    @Column(name = "Coface")
//    private String Coface;

    @Column(name = "Facebook")
    private String Facebook;

    @Column(name = "LinkedIn")
    private String LinkedIn;

    @Column(name = "cmt")
    private String cmt;

   /* @JsonIgnore
    @OneToMany(mappedBy = "societe", cascade = CascadeType.REMOVE)
    private List<Manager> managers = new ArrayList<>();*/

    @Column(name = "etat")
    private String etat;

    @Column(name = "nom_Type")
    private String typesociete;


   /* @JsonIgnore
    @OneToMany(mappedBy = "societe", cascade = CascadeType.REMOVE)
    private List<Prestation> prestations = new ArrayList<>();*/
}

