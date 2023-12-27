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



    @Query(value = "SELECT  ID,NAME_PRESTATION, PRESTATION.ETAT  FROM PRESTATION\n" +
            "JOIN CLIENT_PRESTATION ON PRESTATION.ID = CLIENT_PRESTATION.PRESTATION_ID\n" +
            "JOIN CLIENT ON CLIENT_PRESTATION.CLIENT_ID = CLIENT.ID_CLIENT\n" +
            "WHERE CLIENT.RC_SOCIETE = ? AND CLIENT.RAISON_SOCIALE = ? AND CLIENT.PROPRIETE_SOCIETE = ?",
            nativeQuery = true)
    List<String>  findByUniqueAttributes(
            Long rc,
            String rs,
            String propriete);



    @Query(value = "SELECT ID, NAME_PRESTATION, PRESTATION.ETAT FROM PRESTATION  JOIN CLIENT_PRESTATION ON PRESTATION.ID = CLIENT_PRESTATION.PRESTATION_ID  JOIN CLIENT ON CLIENT_PRESTATION.CLIENT_ID = CLIENT.ID_CLIENT WHERE CLIENT.RC_SOCIETE =:rc ",
            nativeQuery = true)
    List<String>  findByRC(Long rc);

 @Query(value = "SELECT ID, NAME_PRESTATION, PRESTATION.ETAT FROM PRESTATION  JOIN CLIENT_PRESTATION ON PRESTATION.ID = CLIENT_PRESTATION.PRESTATION_ID  JOIN CLIENT ON CLIENT_PRESTATION.CLIENT_ID = CLIENT.ID_CLIENT WHERE CLIENT.RAISON_SOCIALE =:rs ",
         nativeQuery = true)
   List<String>  findByRS(String rs);
 @Query(value = "SELECT ID, NAME_PRESTATION, PRESTATION.ETAT FROM PRESTATION  JOIN CLIENT_PRESTATION ON PRESTATION.ID = CLIENT_PRESTATION.PRESTATION_ID  JOIN CLIENT ON CLIENT_PRESTATION.CLIENT_ID = CLIENT.ID_CLIENT WHERE CLIENT.PROPRIETE_SOCIETE =:propriete ",
         nativeQuery = true)
   List<String>  findBypropriete(String propriete);

    @Query(
            value = "SELECT * FROM PRESTATION WHERE PRESTATION_ID=?",
            nativeQuery = true
    )
    Etape getETAPEByIdPRESTATION(long id);



}

