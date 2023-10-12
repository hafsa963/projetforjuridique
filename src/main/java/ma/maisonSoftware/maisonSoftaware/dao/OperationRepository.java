package ma.maisonSoftware.maisonSoftaware.dao;



import ma.maisonSoftware.maisonSoftaware.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    /*Service FindByService (String Service);*/

    List<Operation> findAll();

}
