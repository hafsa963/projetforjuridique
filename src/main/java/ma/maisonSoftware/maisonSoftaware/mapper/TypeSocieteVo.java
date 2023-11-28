package ma.maisonSoftware.maisonSoftaware.mapper;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeSocieteVo {

    private Long id;
    private String nom;


    public TypeSocieteVo(String nom) {
        this.nom = nom;
    }
}
