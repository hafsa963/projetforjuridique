package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
public class ManagerVo {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String nameManager;


    public ManagerVo(String nameManager) {
        this.nameManager = nameManager;

    }
}
