package ma.maisonSoftware.maisonSoftaware.model;

import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "nameOperation")
    @NotEmpty(message = "*Please provide an OPERATION  name")
    private String nameOperation;




}
