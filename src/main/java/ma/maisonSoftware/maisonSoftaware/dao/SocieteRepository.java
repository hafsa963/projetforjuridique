package ma.maisonSoftware.maisonSoftaware.dao;

import ma.maisonSoftware.maisonSoftaware.model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteRepository extends JpaRepository<Societe,Long> {
//    List<Societe> findBySociete(String societe);
    Societe findByNom(String name);
    Societe findByRc(Long rc);

}
