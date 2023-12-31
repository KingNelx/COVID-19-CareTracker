package COVID19.CareTracker.Service;

import COVID19.CareTracker.Entity.Patient;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
@Service
public interface PatientService {

    ResponseEntity <String> addPatient(Patient patient);
    List <Patient> queryPatients();
    ResponseEntity <String> deletePatientByID(Long id);
    Optional <Patient> queryPatientByID(Long id);

    ResponseEntity <String> updatePatientData(Long id, Patient patient);
    Optional <Patient> allMalePatients();
    Optional <Patient> allFemalePatients();

}
