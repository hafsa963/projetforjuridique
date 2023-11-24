package ma.maisonSoftware.maisonSoftaware.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Manager")
    @Getter
    @Setter
    private long id;

    @Column(name = "name_Manager")
    @NotEmpty(message = "*Please provide an Manager  name")
    @Getter
    @Setter
    private String nameManager;


    @Column(name = "Datedebut")
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    @Getter
    @Setter
    private Date Datedebut;


    @JsonFormat(pattern = "DD-MM-YYYY", shape = JsonFormat.Shape.STRING, timezone = "UTC")
    @Getter
    @Setter
    private Date  DateFin;


    @Getter
    @Setter
    private String  mandatGerance;



    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "societe_id")
    private Societe societe;


    public Manager( String nameManager,
                   Date datedebut, Date dateFin, String mandatGerance, Societe societe) {

        this.nameManager = nameManager;
        Datedebut = datedebut;
        DateFin = dateFin;
        this.mandatGerance = mandatGerance;
        this.societe = societe;
    }


}
