package COVID19.CareTracker.Repository;

import COVID19.CareTracker.Entity.TravelHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelHistoryRepo extends MongoRepository <TravelHistory, String> {
}
