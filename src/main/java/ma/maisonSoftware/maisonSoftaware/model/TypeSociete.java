package ma.maisonSoftware.maisonSoftaware.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@NoArgsConstructor
@Setter
@Getter
public class TypeSociete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type")
    private Long id;

    @Column(name = "nom_Type")
    private String nom;
}
