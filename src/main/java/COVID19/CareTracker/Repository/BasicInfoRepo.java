package COVID19.CareTracker.Repository;

import COVID19.CareTracker.Entity.BasicInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BasicInfoRepo extends MongoRepository <BasicInformation, String> {
    List <BasicInformation> findByGender(String gender);

}
