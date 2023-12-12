package ma.maisonSoftware.maisonSoftaware.dao;

import ma.maisonSoftware.maisonSoftaware.model.Client;
import ma.maisonSoftware.maisonSoftaware.model.Prestation;
import ma.maisonSoftware.maisonSoftaware.model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

   /* @Query("SELECT c FROM Client c LEFT JOIN c.prestations p WHERE p IS NULL")
    List<Client> getClientsWithoutPrestations();

    @Query("SELECT c FROM Client c INNER JOIN c.prestations p WHERE p IS NOT NULL")
    List<Client> getClientsWithPrestations();*/
   @Query(

           value = "  SELECT DISTINCT CLIENT.*, CLIENT_PRESTATION.CLIENT_ID AS prestation_client_id, CLIENT_PRESTATION.PRESTATION_ID AS prestation_prestation_id\n" +
                   "FROM CLIENT\n" +
                   "LEFT JOIN CLIENT_PRESTATION ON CLIENT.ID_CLIENT = CLIENT_PRESTATION.CLIENT_ID\n" +
                   "WHERE CLIENT_PRESTATION.CLIENT_ID IS NULL OR CLIENT_PRESTATION.CLIENT_ID IS NOT NULL;",
            nativeQuery = true
   )
   List<Client> getClientsWithAndWithoutPrestations();
    //value = "SELECT * FROM CLIENT LEFT JOIN CLIENT_PRESTATION ON CLIENT.ID_CLIENT = CLIENT_PRESTATION.CLIENT_ID WHERE CLIENT_PRESTATION.CLIENT_ID IS NOT NULL",
    //value = "SELECT * FROM CLIENT LEFT JOIN CLIENT_PRESTATION ON CLIENT.ID_CLIENT = CLIENT_PRESTATION.CLIENT_ID WHERE CLIENT_PRESTATION.CLIENT_ID IS NULL OR CLIENT_PRESTATION.CLIENT_ID IS NOT NULL",
    // SELECT * FROM CLIENT LEFT JOIN CLIENT_PRESTATION ON CLIENT.ID_CLIENT = CLIENT_PRESTATION.CLIENT_ID WHERE CLIENT_PRESTATION.CLIENT_ID IS NULL OR CLIENT_PRESTATION.CLIENT_ID IS NOT NULL
    Client findByRs(String rs);
    Client findByRc(Long rc);
     // Client findByi_f(Long i_f);

     Client findByCnss(Long cnss);
     Client findByIce(Long ice);
    Client findByIp(Long ip);
    Client findByPropriete(String propriete);
    Client findByCtNum(String ctNum);
    Client findByForme(String forme);
     Client findByCapitale(String capitale);
     Client findBySiege(String siege);
    Client findBytypesociete(String typesociete);
    //Client findByI_F(Long i_f);





}
