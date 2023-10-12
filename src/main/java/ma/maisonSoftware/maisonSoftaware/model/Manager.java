package ma.maisonSoftware.maisonSoftaware.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nameManager")
    @NotEmpty(message = "*Please provide an Manager  name")
    private String nameManager;
    @ManyToOne
    private Societe societe;
}
