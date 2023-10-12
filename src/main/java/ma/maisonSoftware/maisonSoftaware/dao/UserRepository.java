package ma.maisonSoftware.maisonSoftaware.dao;

import ma.maisonSoftware.maisonSoftaware.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);
    boolean existsByUsername(String username);
}