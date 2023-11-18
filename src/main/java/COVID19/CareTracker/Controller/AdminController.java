package COVID19.CareTracker.Controller;

import COVID19.CareTracker.Entity.Admin;
import COVID19.CareTracker.Entity.Patient;
import COVID19.CareTracker.Service.AdminService;
import COVID19.CareTracker.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private PatientService patientService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createAccount(@RequestBody Admin admin){
        return adminService.createAccount(admin);
    }

    @GetMapping("/sign-in")
    public ResponseEntity <String> adminLogIn(@RequestParam String adminEmail, @RequestParam String adminUserName, @RequestParam String adminPassword){
        return adminService.adminLogIn(adminEmail, adminUserName, adminPassword);
    }

    @GetMapping("/queryAll")
    public List <Admin> queryAdmins(){
        return adminService.queryAdmins();
    }

    // PATIENTS
    @PostMapping("/patient/register-patient")
    public ResponseEntity <String> addNewPatient(@RequestBody Patient patient){
        return patientService.addNewPatient(patient);
    }

    @GetMapping("/patient/query-patients")
    public List <Patient> queryPatients(){
        return patientService.queryPatients();
    }
}
