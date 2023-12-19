package ma.maisonSoftware.maisonSoftaware.dao;

import ma.maisonSoftware.maisonSoftaware.mapper.PrestationVo;
import ma.maisonSoftware.maisonSoftaware.model.Client;
import ma.maisonSoftware.maisonSoftaware.model.Etape;
import ma.maisonSoftware.maisonSoftaware.model.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrestationRepository extends JpaRepository<Prestation,Long> {
    @Query(
            value = "SELECT * FROM PRESTATION WHERE Etape_ID=?",
            nativeQuery = true
    )
   Prestation getPrestationByIdEtape(long id);


    @Query(value = " SELECT * FROM Prestation ",
            nativeQuery = true)
    List<Prestation> getAllPrestation();


    Prestation findByNamePrestation(String namePrestation);


    Prestation findByid(long id);



    @Query(
            value = "SELECT P.NAME_PRESTATION " +
                    "FROM PRESTATION P " +
                    "JOIN CLIENT_PRESTATION CP ON P.ID = CP.PRESTATION_ID " +
                    "WHERE CP.CLIENT_ID = :clientId",
            nativeQuery = true
    )
    List<String> getPrestationsClientByID(@Param("clientId") long clientId);

}

