package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.mapper.DocumentDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class DocumentServiceImpl implements DocumentService{
    @Override
    public void insererDocument(MultipartFile file) {
        /*try {
            if (!file.isEmpty()) {
                // Spécifiez le chemin de destination où vous souhaitez enregistrer le fichier
                String cheminDeDestination = "C:/Users/zineb%20kourifa/OneDrive/Documents/Bureau/elmaguiriapp/" + file.getOriginalFilename();

                // Enregistrez le fichier sur le serveur
                byte[] bytes = file.getBytes();
                Path chemin = Paths.get(cheminDeDestination);
                Files.write(chemin, bytes);

                // Vous pouvez effectuer d'autres opérations sur le fichier ici, si nécessaire

                System.out.println("Document inséré avec succès.");
            } else {
                System.err.println("Le fichier est vide.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur lors de l'insertion du document : " + e.getMessage());
            // Gérez les erreurs en cas de problème lors de l'insertion du document
        }*/
    }

    @Override
    public String updateDocument(DocumentDto dto) {
        return null;
    }

    @Override
    public String deleteById(int idEtape) {
        return null;
    }
}
