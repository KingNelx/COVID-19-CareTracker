package COVID19.CareTracker.Controller;

import COVID19.CareTracker.Entity.Admin;
import COVID19.CareTracker.Entity.BasicInformation;
import COVID19.CareTracker.Service.AdminService;
import COVID19.CareTracker.Service.BasicInfoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@NoArgsConstructor
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BasicInfoService basicInfoService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createAccount(@RequestBody Admin admin){
        return adminService.createAccount(admin);
    }

    @GetMapping("/sign-in")
    public ResponseEntity <String> logInAsAdmin(@RequestParam String email, @RequestParam String userName, @RequestParam String password, @RequestParam String specialCharacters){
        return adminService.logInAsAdmin(email, userName, password, specialCharacters);
    }

    @PutMapping("/update-account")
    public ResponseEntity <String> updateAdminData(@PathVariable String id, @RequestBody Admin admin){
        return adminService.updateAdminData(id, admin);
    }

    // PATIENTS SERVICE

    @PostMapping("/add-patient")
    public ResponseEntity <String> addPatient(@RequestBody BasicInformation basicInformation){
        return basicInfoService.addPatient(basicInformation);
    }

    @GetMapping("/list-of-patients")
    public List <BasicInformation> getPatients(){
        return basicInfoService.getPatients();
    }

    @GetMapping("/patient-data-by-id/{id}")
    public Optional <BasicInformation> getPatientByID(@PathVariable String id){
        return basicInfoService.getPatientByID(id);
    }

    @PutMapping("/patient-update-by-id/{id}")
    public ResponseEntity <String> updatePatientData(@PathVariable String id, @RequestBody BasicInformation basicInformation){
        return basicInfoService.updatePatientData(id, basicInformation);
    }

    @DeleteMapping("/delete-patient-data-id/{id}")
    public ResponseEntity <String> deletePatientData(@PathVariable String id){
        return basicInfoService.deletePatientData(id);
    }

    @GetMapping("/patient-males")
    public List <BasicInformation> getAllMalePatients(){
        return basicInfoService.getAllMalePatients();
    }

    @GetMapping("/patient-females")
    public List <BasicInformation> getAllFemalePatients(){
        return basicInfoService.getAllFemalePatients();
    }

}
