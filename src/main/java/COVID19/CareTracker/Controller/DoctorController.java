package COVID19.CareTracker.Controller;

import COVID19.CareTracker.Entity.Doctor;
import COVID19.CareTracker.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createAccount(@RequestBody Doctor doctor){
        return doctorService.doctorRegister(doctor);
    }

    @GetMapping("/queryDoctors")
    public List <Doctor> queryDoctors(){
        return doctorService.queryDoctors();
    }
}
