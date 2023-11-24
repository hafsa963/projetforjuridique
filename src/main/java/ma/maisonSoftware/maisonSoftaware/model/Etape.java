package ma.maisonSoftware.maisonSoftaware.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Etape implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtape;

    private String nomEtape;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "PRESTATION_ID")

    private Prestation prestation;

    public Etape(String nomEtape, Prestation prestation) {
        this.nomEtape = nomEtape;
        this.prestation = prestation;
    }



}
