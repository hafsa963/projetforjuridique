package ma.maisonSoftware.maisonSoftaware.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
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

   // @Column(nullable = false)
    private String ctNum;



    @Column(name = "qualite")
    private String qualite;



    @Column(name = "adresse")
    private String adresse;

    @Column(name = "complement")
    private String complement;

    @Column(name = "codepostal")
    private String codepostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "coderegion")
    private String coderegion;

    @Column(name = "pays")
    private String pays;

    @Column(name = "tel")
    private String tel;

    @Column(name = "telcopie")
    private String telcopie;

    @Column(name = "email")
    private String email;


    @Column(name = "cmt")
    private String cmt;

    @Column(name = "etat")
    private String etat;

    @Column(name = "nom_Type")
    private String typesociete;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clients", cascade = CascadeType.ALL)
   List<AttachmentEntity> attachmentEntity;

  /* @JsonIgnore
    @OneToMany(mappedBy = "societe", cascade = CascadeType.REMOVE)
    private List<Manager> managers = new ArrayList<>();*/
   /* @JsonIgnore
    @OneToMany(mappedBy = "societe", cascade = CascadeType.REMOVE)
    private List<Prestation> prestations = new ArrayList<>();*/
}

