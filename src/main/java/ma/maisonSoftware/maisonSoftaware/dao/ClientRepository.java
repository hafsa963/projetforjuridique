package ma.maisonSoftware.maisonSoftaware.dao;

import ma.maisonSoftware.maisonSoftaware.model.Client;
import ma.maisonSoftware.maisonSoftaware.model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
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
