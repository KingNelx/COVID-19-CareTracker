package COVID19.CareTracker.Service;

import COVID19.CareTracker.Entity.TravelHistory;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.List;
@Service
public interface TravelService {

    ResponseEntity <String> addTravelHistory(TravelHistory travelHistory);
    List <TravelHistory> queryHistory();

}
