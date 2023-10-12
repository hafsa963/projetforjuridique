package ma.maisonSoftware.maisonSoftaware.dao;

import ma.maisonSoftware.maisonSoftaware.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DepartementRepository extends JpaRepository<Departement,Long> {
}
