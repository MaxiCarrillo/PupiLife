package max.sofi.pupilife.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadFile {
	
	 /**
	 * Atributo constante que permite determinar en que carpeta se van a subir las imagenes. 
	 */
	private final static String UPLOADS_FOLDER = "src/main/resources/static/uploads";
	
	/**
	 * Metodo que devuelve una ruta (Path).
	 * @param filename
	 * @return
	 */
	public Path getPath(String filename) {
        return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
    }
	
	/**
	 * Permite cargar/leer una imagen.
	 * @param filename
	 * @return
	 * @throws MalformedURLException
	 */
	public Resource load(String filename) throws MalformedURLException {
        Path path = getPath(filename);
        Resource resource = new UrlResource(path.toUri());
        if (!resource.exists() || !resource.isReadable()) {
            throw new RuntimeException("Error en Resource load: " + path.toString());
        }
        return resource;
	}
	
	 /**
	 * Permite guardar una copiar la imagen subida al proyecto.
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String copy(MultipartFile file) throws IOException {
        String uniqueFilename = UUID.randomUUID().toString() + "_" +
                file.getOriginalFilename();
        Path rootPath = getPath(uniqueFilename);
        Files.copy(file.getInputStream(), rootPath);
        return uniqueFilename;
    }
	 
	 /**
	 * Permite borrar una imagen.
	 * @param filename
	 * @return
	 */
	public boolean delete(String filename) {
        Path rootPath = getPath(filename);
        File file = rootPath.toFile();
        if (file.exists() && file.canRead()) {
            if (file.delete()) {
                return true;
            }
        }
        return false;
    }
}
