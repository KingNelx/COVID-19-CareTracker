package COVID19.CareTracker.Repository;

import COVID19.CareTracker.Entity.MedicalHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepo extends MongoRepository <MedicalHistory, String> {
}
