  package ma.maisonSoftware.maisonSoftaware.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Societe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Societe")
    private Long id;

    @Column(name = "nom_Societe")
    private String nom;

    @Column(name = "forme_Societe")
    private String forme;

    @Column(name = "capitale_Societe")
    private String capitale;

    @Column(name = "seige_Societe")
    private String siege;

    @Column(unique = true,nullable = false,name = "Rc_Societe")
    private Long rc;

    @Column(name = "if_Societe")
    private Long i_f;

    @Column(name = "ice_Societe")
    private Long ice;

    @Column(name = "ip_Societe")
    private Long ip;

    @Column(name = "cnss_Societe")
    private Long cnss;

    @Column(name = "propriete_Societe",nullable = false)
    private String propriete;
    @JsonIgnore
    @OneToMany(mappedBy = "societe", cascade = CascadeType.REMOVE )
   private List<Manager> managers = new ArrayList<>();

      @OneToOne(fetch = FetchType.LAZY)
      @JsonIgnore
      private AttachmentEntity attachmentEntity;

    public Societe(String nom, String forme, String capitale, String siege, Long rc, Long i_f, Long ice, Long ip, Long cnss, String propriete,List<Manager> managers) {
        this.nom = nom;
        this.forme = forme;
        this.capitale = capitale;
        this.siege = siege;
        this.rc = rc;
        this.i_f = i_f;
        this.ice = ice;
        this.ip = ip;
        this.cnss = cnss;
        this.propriete = propriete;
        this.managers=  managers;
    }
}
