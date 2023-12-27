package ma.maisonSoftware.maisonSoftaware.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prestation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(unique = true,nullable = false,name = "NamePrestation")
    @NotEmpty(message = "* Please provide a prestation name")
    @Getter
    @Setter
    private String namePrestation;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prestation",cascade =CascadeType.REMOVE)
    @Getter
    @Setter
    private List<Etape> etapes = new ArrayList<>();

    @Column(name = "Etat")

    @Getter
    @Setter
    private String Etat;

    @Getter
    @Setter

    @ManyToMany(mappedBy = "prestations",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    List<Client> clients = new ArrayList<>();

    public Prestation(String namePrestation, List<Etape> etapes, String etat) {

        this.namePrestation = namePrestation;
        this.etapes = etapes;
        Etat = etat;
    }




}
