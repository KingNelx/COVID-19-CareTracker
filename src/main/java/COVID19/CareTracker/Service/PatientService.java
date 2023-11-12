package COVID19.CareTracker.Service;

import COVID19.CareTracker.Entity.Patient;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
@Service
public interface PatientService {

    ResponseEntity <String> addPatient(Patient patient);
}
