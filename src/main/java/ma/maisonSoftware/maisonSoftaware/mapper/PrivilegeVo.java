package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@Data
@NoArgsConstructor
public class PrivilegeVo implements GrantedAuthority {
    private Long id;
    private String privilege;
    @Override
    public String getAuthority() {
        return this.privilege;
    }
    public PrivilegeVo(String privilege) {
        this.privilege = privilege;
    }
}
