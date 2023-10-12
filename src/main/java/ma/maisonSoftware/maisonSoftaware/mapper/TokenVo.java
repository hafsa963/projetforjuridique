package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenVo {
    private String username;
    private String jwttoken;
    private    String role;
}

