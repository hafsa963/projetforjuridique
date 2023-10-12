package ma.maisonSoftware.maisonSoftaware.dao;

import ma.maisonSoftware.maisonSoftaware.model.Etape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EtapeRepository extends JpaRepository<Etape, Integer> {

    @Query(
            value = "SELECT * FROM ETAPE WHERE PRESTATION_ID=?",
            nativeQuery = true
    )
    List<Etape> getEtapeByIdPrestation(long id);

    Etape findByIdEtapeAndPrestation_Id(int idEtape, long idPrestation);



}
