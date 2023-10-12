package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocieteVo {
    private Long id;
    private String nom;

    private String forme;
    private String capitale;
    private String siege;
    private Long rc;
    private Long i_f;
    private Long ice;
    private Long ip;
    private Long cnss;
    private String propriete;

    public SocieteVo(String nom, String forme, String capitale, String siege, Long rc, Long i_f, Long ice, Long ip, Long cnss, String propriete) {
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
    }
}
