package ma.maisonSoftware.maisonSoftaware.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

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

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "societe_id")
    private Societe societe;

    public Manager(String nameManager) {
        this.nameManager = nameManager;
    }
}
