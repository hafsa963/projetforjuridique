package ma.maisonSoftware.maisonSoftaware.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Entity
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocument;

    private String nomDocument;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Etape etape;

}
