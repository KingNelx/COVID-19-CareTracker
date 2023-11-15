package COVID19.CareTracker.Repository;

import COVID19.CareTracker.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface DocRepo extends JpaRepository <Doctor, Long> {

    Optional <Doctor> findByFirstName(String firstName);
    Optional <Doctor> findByLastName(String lastName);
}
