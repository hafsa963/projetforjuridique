package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartementVo {
    private Long id;
    private String nomDepartement;

    public DepartementVo(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }
}
