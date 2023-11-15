package COVID19.CareTracker.Service;

import COVID19.CareTracker.Entity.Doctor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import org.springframework.http.ResponseEntity;

@Service
public interface DoctorService {

    ResponseEntity <String> createDoctor(Doctor doctor);
    List <Doctor> queryDoctors();
    Optional <Doctor> queryDoctorByID(String id);
    ResponseEntity <String> updateDoctorsData(String id, Doctor doctor);
    ResponseEntity <String> removeDoctorsData(String id);
}
