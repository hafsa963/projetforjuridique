package ma.maisonSoftware.maisonSoftaware.dao;

import ma.maisonSoftware.maisonSoftaware.mapper.PrestationVo;
import ma.maisonSoftware.maisonSoftaware.model.Client;
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

    //@Query(value = "SELECT new ma.maisonSoftware.maisonSoftaware.mapper.PrestationVo(p.namePrestation, p.etat, p.etapeDtoList) FROM Prestation p",
   /*@Query(value = " SELECT ID,NAME_Prestation FROM Prestation ",
           nativeQuery = true)
   List<PrestationVo> getAllPrestation();*/

    @Query(value = " SELECT * FROM Prestation ",
            nativeQuery = true)
    List<Prestation> getAllPrestation();


    Prestation findByNamePrestation(String namePrestation);


    Prestation findByid(long id);
}

