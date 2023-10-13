package ma.maisonSoftware.maisonSoftaware.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String nomDepartement;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private DepatrementTypeEnum depatrementTypeEnum;

    public Departement(String nomDepartement, DepatrementTypeEnum depatrementTypeEnum) {
        this.nomDepartement = nomDepartement;
        this.depatrementTypeEnum = depatrementTypeEnum;
    }


}