package COVID19.CareTracker.Service;

import COVID19.CareTracker.Entity.Doctor;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.List;
@Service
public interface DoctorService {

    ResponseEntity <String> doctorRegister(Doctor doctor);
    List <Doctor> queryDoctors();
}
