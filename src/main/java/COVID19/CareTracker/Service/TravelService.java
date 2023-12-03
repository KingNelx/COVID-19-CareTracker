package COVID19.CareTracker.Service;

import COVID19.CareTracker.Entity.TravelHistory;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
@Service
public interface TravelService {

    ResponseEntity <String> addTravelHistory(TravelHistory travelHistory);
}
