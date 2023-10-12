package ma.maisonSoftware.maisonSoftaware.dao;

import ma.maisonSoftware.maisonSoftaware.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String role);

    List<Role> findAll();
    boolean existsByRole(String role);
}
