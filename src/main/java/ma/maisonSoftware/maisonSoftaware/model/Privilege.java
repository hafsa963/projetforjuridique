package ma.maisonSoftware.maisonSoftaware.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
public class Privilege implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String privilege;



    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles = new ArrayList<>();

    public Privilege(String privilege) {
        this.privilege = privilege;
    }
}
