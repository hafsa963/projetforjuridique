package ma.maisonSoftware.maisonSoftaware.dao;

import ma.maisonSoftware.maisonSoftaware.model.Client;
import ma.maisonSoftware.maisonSoftaware.model.Prestation;
import ma.maisonSoftware.maisonSoftaware.model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query(
            value = " SELECT\n" +
                    "    CLIENT.ID_CLIENT, CLIENT.ADRESSE, CLIENT.CAPITALE_SOCIETE, CLIENT.CMT, CLIENT.CNSS_SOCIETE, CLIENT.CODEPOSTAL, CLIENT.CODEREGION, CLIENT.COMPLEMENT, CLIENT.CT_NUM, CLIENT.EMAIL, CLIENT.ETAT, CLIENT.FORME_SOCIETE,\n" +
                    "    CLIENT.IF_SOCIETE, CLIENT.ICE_SOCIETE, CLIENT.IP_SOCIETE, CLIENT.PAYS, CLIENT.QUALITE,\n" +
                    "    CLIENT.RC_SOCIETE, CLIENT.RAISON_SOCIALE, CLIENT.SEIGE_SOCIETE, CLIENT.TEL, CLIENT.TELCOPIE, CLIENT.NOM_TYPE, CLIENT.VILLE,\n" +
                    "    CLIENT.PROPRIETE_SOCIETE, CLIENT.DISPLAY_CLIENT,\n" +
                    "    MAX(CLIENT_PRESTATION.CLIENT_ID) AS PRESTATION_CLIENT_ID,\n" +
                    "    MAX(CLIENT_PRESTATION.PRESTATION_ID) AS PRESTATION_PRESTATION_ID\n" +
                    "FROM\n" +
                    "    CLIENT\n" +
                    "LEFT JOIN\n" +
                    "    CLIENT_PRESTATION ON CLIENT.ID_CLIENT = CLIENT_PRESTATION.CLIENT_ID\n" +
                    "WHERE\n" +
                    "    CLIENT.DISPLAY_CLIENT = true\n" +
                    "GROUP BY\n" +
                    "    CLIENT.ID_CLIENT, CLIENT.ADRESSE, CLIENT.CAPITALE_SOCIETE, CLIENT.CMT, CLIENT.CNSS_SOCIETE, CLIENT.CODEPOSTAL, CLIENT.CODEREGION, CLIENT.COMPLEMENT, CLIENT.CT_NUM, CLIENT.EMAIL, CLIENT.ETAT, CLIENT.FORME_SOCIETE,\n" +
                    "    CLIENT.IF_SOCIETE, CLIENT.ICE_SOCIETE, CLIENT.IP_SOCIETE, CLIENT.PAYS, CLIENT.QUALITE,\n" +
                    "    CLIENT.RC_SOCIETE, CLIENT.RAISON_SOCIALE, CLIENT.SEIGE_SOCIETE, CLIENT.TEL, CLIENT.TELCOPIE, CLIENT.NOM_TYPE, CLIENT.VILLE,\n" +
                    "    CLIENT.PROPRIETE_SOCIETE;\n",

            nativeQuery = true
    )
    List<Client> getClientsWithAndWithoutPrestations();


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




}
