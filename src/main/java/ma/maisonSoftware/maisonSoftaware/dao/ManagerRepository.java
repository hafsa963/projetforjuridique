package ma.maisonSoftware.maisonSoftaware.dao;



import ma.maisonSoftware.maisonSoftaware.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository <Manager,Long> {
    List<Manager> findAll();

}
