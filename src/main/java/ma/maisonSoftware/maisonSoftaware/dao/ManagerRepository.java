package ma.maisonSoftware.maisonSoftaware.dao;



import ma.maisonSoftware.maisonSoftaware.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManagerRepository extends JpaRepository <Manager,Long> {
    @Query("SELECT m FROM Manager m LEFT JOIN m.client")
    List<Manager> findAllMangers();

}
