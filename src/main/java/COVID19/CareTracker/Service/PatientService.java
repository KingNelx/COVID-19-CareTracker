package COVID19.CareTracker.Service;

import COVID19.CareTracker.Entity.Patient;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
@Service
public interface PatientService {

    ResponseEntity <String> addNewPatient(Patient patient);
    List <Patient> queryPatients();
    Optional <Patient> queryPatientByID(String id);
    ResponseEntity <String> updatePatientData(String id, Patient patient);
    ResponseEntity <String> removePatientData(String id);

}
