package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.Objects;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class FilesUploadService {


    private final Path rootLocation;

    private static final String DEFAULT_MIMETYPE = "application/octet-stream";

    public FilesUploadService(@Value("${storage.uploadDir}") final String uploadDir) {
        this.rootLocation = Paths.get(uploadDir);
    }

    public void uploadFile(final MultipartFile file, final String path)  {

        if (path == null) {
            throw new BusinessException("path not found");
        }


        try {
            final Path folderDir = this.rootLocation.resolve(path);
            Files.createDirectories(folderDir);
            final Path destinationFile = folderDir.resolve(
                    Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream,  destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

        } catch (final IOException e) {
            throw new BusinessException("");

        }
    }
    public int countFilesInFolder(final String folderName) {
        try {
            final Path folderDir = this.rootLocation.resolve(folderName);
            if (Files.exists(folderDir) && Files.isDirectory(folderDir)) {
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(folderDir)) {
                    return (int) StreamSupport.stream(stream.spliterator(), false).count();
                }
            }
        } catch (final IOException e) {
            throw new BusinessException("");
        }
        return 0;
    }


    private String extractFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex > 0) {
            return filename.substring(lastDotIndex + 1);
        }
        return "";
    }


    public byte[] download(String path) {

        Path filePath = this.rootLocation.resolve(path);

        if (!Files.exists(filePath)) {
            throw new BusinessException("");
        }

        File file = filePath.toFile();

        byte[] fileBytes = null;

        try {
            if (file.isFile()) {

                fileBytes = Files.readAllBytes(filePath);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileBytes;
    }
}



