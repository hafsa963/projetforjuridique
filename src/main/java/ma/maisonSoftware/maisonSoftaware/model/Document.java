package ma.maisonSoftware.maisonSoftaware.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocument;

    @Getter
    @Setter
    private String titredocument;

    @Getter
    @Setter
    private String Description;

    @Getter
    @Setter
    @Lob
    private byte[] fileContent;

    private Date datedentredoq;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Etape etape;

}
