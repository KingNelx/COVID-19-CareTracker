package COVID19.CareTracker.Repository;

import COVID19.CareTracker.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository <Patient, Long> {
    Optional <Patient> findByPatientID(String patientID);
    Optional <Patient> findByFirstName(String firstName);
    Optional <Patient> findByLastName(String lastName);
    Optional <Patient> findByGender(String gender);
}
