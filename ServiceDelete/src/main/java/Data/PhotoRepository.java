package Data;

import Model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
    Photo findByTitle(int title);
    void deleteByTitle(int title);


}

