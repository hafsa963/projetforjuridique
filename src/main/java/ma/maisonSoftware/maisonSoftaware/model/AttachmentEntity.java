package ma.maisonSoftware.maisonSoftaware.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class AttachmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String imagePath;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private Client clients ;

}
