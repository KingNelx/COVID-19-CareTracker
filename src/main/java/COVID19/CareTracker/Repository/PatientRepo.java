package COVID19.CareTracker.Repository;

import COVID19.CareTracker.Entity.Patient;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PatientRepo {
    Optional <Patient> findByFirstName(String firstName);
    Optional <Patient> findByLastName(String lastName);
    Optional <Patient> findByPatientID(String patientID);
}
