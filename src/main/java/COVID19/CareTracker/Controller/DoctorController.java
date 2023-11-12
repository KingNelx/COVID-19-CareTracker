package COVID19.CareTracker.Controller;

import COVID19.CareTracker.Entity.Doctor;
import COVID19.CareTracker.Entity.Patient;
import COVID19.CareTracker.Service.DoctorService;
import COVID19.CareTracker.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createAccount(@RequestBody Doctor doctor){
        return doctorService.doctorRegister(doctor);
    }

    @GetMapping("/queryDoctors")
    public List <Doctor> queryDoctors(){
        return doctorService.queryDoctors();
    }

    // PATIENT
    @PostMapping("/patient/add-new-patient")
    public ResponseEntity <String> addNewPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }
}
