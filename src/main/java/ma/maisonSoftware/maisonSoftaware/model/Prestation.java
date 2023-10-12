package ma.maisonSoftware.maisonSoftaware.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Prestation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(name = "NamePrestation")
    @NotEmpty(message = "* Please provide a prestation name")
    @Getter
    @Setter
    private String namePrestation;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prestation",cascade =CascadeType.REMOVE)
    @Getter
    @Setter
    private List<Etape> etapes = new ArrayList<>();

    public Prestation(String namePrestation, List<Etape> etapes) {
        this.namePrestation = namePrestation;
        this.etapes = etapes;
    }




}
