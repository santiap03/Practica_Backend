package Service;

import Model.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.NoSuchElementException;

public interface PhotoService {
    String addPhoto(int title, MultipartFile file) throws IOException;
    Photo getPhoto(String id) throws NoSuchElementException;
    Photo getPhotoByTitle(int title);
    public String updatePhoto(int title, MultipartFile file) throws IOException;
}
