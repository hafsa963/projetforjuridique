
package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.dao.PrivilegeRepository;
import ma.maisonSoftware.maisonSoftaware.dao.RoleRepository;
import ma.maisonSoftware.maisonSoftaware.dao.UserRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.*;
import ma.maisonSoftware.maisonSoftaware.exception.BusinessException;
import ma.maisonSoftware.maisonSoftaware.model.Privilege;
import ma.maisonSoftware.maisonSoftaware.model.Role;
import ma.maisonSoftware.maisonSoftaware.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository1;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;


    @Override
    public void save(PrivilegeVo vo) {
        Privilege bo = PrivilegeConverter.toBo(vo);
        Privilege privilegePersist = privilegeRepository.findByPrivilege(bo.getPrivilege());
        if (privilegePersist == null)
            privilegePersist = privilegeRepository.save(bo);
    }

    @Override
    public void save(RoleVo vo) {
        Role bo = RoleConverter.toBo(vo);
        Role rolePersist = roleRepository.findByRole(bo.getRole());
        List<Privilege> privilegeList = new ArrayList<>();
        if (rolePersist == null) {
            vo.getPrivileges().forEach(p -> {
                Privilege privilege = PrivilegeConverter.toBo(p);
                Privilege privilegePersist = privilegeRepository.findByPrivilege(privilege.getPrivilege());
                if (privilegePersist == null)
                    privilegePersist = privilegeRepository.save(privilege);
                privilegeList.add(privilegePersist);

            });
            bo.setPrivileges(privilegeList);
            roleRepository.save(bo);
        }
    }


    @Override

    public void save(UserVo vo) {
        User bo = UserConverter.toBo(vo);
        bo.setPassword(passwordEncoder.encode(vo.getPassword()));
        List<Role> roleList = new ArrayList<>();
        bo.getRoles().forEach(r -> {
            Role rolePersist = roleRepository.findByRole(r.getRole());
//           List<Role> rolePersist = roleRepository.findByRole(r.getRole());
            List<Privilege> privilegeList = new ArrayList<>();
            if (rolePersist == null) {
                r.getPrivileges().forEach(p -> {
                    Privilege privilegePersist = privilegeRepository.findByPrivilege(p.getPrivilege());
                    if (privilegePersist == null)
                        privilegePersist = privilegeRepository.save(p);
                    privilegeList.add(privilegePersist);

                });
                r.setPrivileges(privilegeList);
                rolePersist = roleRepository.save(r);
            }
            roleList.add((Role) rolePersist);
        });
        bo.setRoles(roleList);
        userRepository1.save(bo);

    }







    @Override

    public RoleVo findByRole(String role) {

        return RoleConverter.toVo(roleRepository.findByRole(role));
    }

    @Override
    public void delete(long id) {
        userRepository1.deleteById(id);
    }

    @Override
    public UserVo getuserById(Long id) {

        boolean trouver = userRepository1.existsById(id);
        if (!trouver) return null;
        return UserConverter.toVo(userRepository1.getById(id));

    }


    @Override
    public List<UserVo> getAllUsers() {
        List<User> list = userRepository1.findAll();
        return UserConverter.toVoList(list);
    }

    @Override
    public List<RoleVo> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return RoleConverter.toVoList(roles);
    }


    @Override
    public void cleanDataBase() {
        userRepository1.deleteAll();
        roleRepository.deleteAll();

    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository1.existsByUsername(username);
    }

    @Override
    public boolean existsByRole(String role) {

        return roleRepository.existsByRole(role);
    }

    @Override
    public UserVo findByUsername(String username) {
        if (username == null || username.trim().equals(""))
            throw new BusinessException("login is empty !!");

        User bo = userRepository1.findByUsername(username);

        if (bo == null)
            throw new BusinessException("No user with this login");

        UserVo vo = UserConverter.toVo(bo);
        return vo;

    }

    @Override
    public List<UserVo> findAll(int pageId, int size) {
        Page<User> result = userRepository1.findAll(PageRequest.of(pageId,size, Sort.Direction.ASC,"username"));
        return UserConverter.toVoList(result.getContent());
    }

    @Override
    public List<UserVo> sortBy(String fieldName) {
        return UserConverter.toVoList(userRepository1.findAll(Sort.by(Sort.Direction.ASC,fieldName)));
    }




    @Override
    public UserVo createcolab(UserVo uservo){
        User user = UserConverter.toBo(uservo);
        User savedUser =  userRepository1.save(user);

        return UserConverter.toVo(savedUser);
    }


    /*  @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          return UserConverter.toVo(userRepository1.findByUsername(username));
      }*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository1.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return UserConverter.toVo(user);
    }
    @Override
    public UserDetails  getCurrentUserDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken ) {
            throw new UsernameNotFoundException("User not authenticated");
        }
        return (UserDetails) authentication.getPrincipal();
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .permitAll()
                .defaultSuccessUrl("/")
                .and()
                .httpBasic()
                .and()
                .logout()
                .permitAll();
    }

   /* private PersistentTokenRepository persistenTokenRepository() {

    }*/

}
