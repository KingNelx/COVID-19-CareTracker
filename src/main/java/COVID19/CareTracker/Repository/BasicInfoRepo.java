package COVID19.CareTracker.Repository;

import COVID19.CareTracker.Entity.BasicInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInfoRepo extends MongoRepository <BasicInformation, String> {
}
