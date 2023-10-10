package COVID19.CareTracker.Repository;

import COVID19.CareTracker.Entity.SpecificInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificRepo extends MongoRepository <SpecificInformation, String> {
}
