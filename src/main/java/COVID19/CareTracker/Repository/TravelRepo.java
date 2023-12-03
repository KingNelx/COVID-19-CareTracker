package COVID19.CareTracker.Repository;

import COVID19.CareTracker.Entity.TravelHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepo extends JpaRepository <TravelHistory, Long> {
}
