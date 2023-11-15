package COVID19.CareTracker.Controller;

import COVID19.CareTracker.Entity.Doctor;
import COVID19.CareTracker.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createAccount(@RequestBody Doctor doctor){
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/queryDoctors")
    public List <Doctor> queryDoctors(){
        return doctorService.queryDoctors();
    }

    @GetMapping("/query-data-byID/{id}")
    public Optional <Doctor> queryDoctorByID(@PathVariable String id){
        return doctorService.queryDoctorByID(id);
    }

    @PutMapping("/update-data-byID/{id}")
    public ResponseEntity <String> updateDataByID(@PathVariable String id, @RequestBody Doctor doctor){
        return doctorService.updateDoctorsData(id, doctor);
    }

    @DeleteMapping("/delete-data-byID/{id}")
    public ResponseEntity <String> deleteDataByID(@PathVariable String id){
        return doctorService.removeDoctorsData(id);
    }
}
