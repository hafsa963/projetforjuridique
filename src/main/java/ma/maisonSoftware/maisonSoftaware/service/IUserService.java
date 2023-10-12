
package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.mapper.PrivilegeVo;
import ma.maisonSoftware.maisonSoftaware.mapper.RoleVo;
import ma.maisonSoftware.maisonSoftaware.mapper.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    void save(UserVo user);
    void save(RoleVo role);
    void save(PrivilegeVo vo);
    List<UserVo> getAllUsers();
    List<RoleVo> getAllRoles();
    RoleVo findByRole(String role);
    void delete(long id);
    UserVo getuserById(Long id);

    //    RoleVo getRoleByName(String role);
    void cleanDataBase();
    boolean existsByUsername(String username);
    boolean existsByRole(String role);
    UserVo findByUsername(String username);
    List<UserVo> findAll(int pageId, int size);
    //pour le tri
    List<UserVo> sortBy(String fieldName);
}

