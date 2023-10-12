package ma.maisonSoftware.maisonSoftaware.dao;

import ma.maisonSoftware.maisonSoftaware.model.Etape;
import ma.maisonSoftware.maisonSoftaware.model.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrestationRepository extends JpaRepository<Prestation,Long> {
    @Query(
            value = "SELECT * FROM PRESTATION WHERE Etape_ID=?",
            nativeQuery = true
    )
   Prestation getPrestationByIdEtape(long id);
}
