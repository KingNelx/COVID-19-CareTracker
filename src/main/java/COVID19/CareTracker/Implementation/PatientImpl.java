package COVID19.CareTracker.Implementation;

import COVID19.CareTracker.Entity.Patient;
import COVID19.CareTracker.Repository.PatientRepo;
import COVID19.CareTracker.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;

@Service
public class PatientImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Override
    @Transactional
    public ResponseEntity <String> addPatient(@RequestBody Patient patient){
        Optional <Patient> existingFirstName = patientRepo.findByFirstName(patient.getFirstName());
        Optional <Patient> existingLastName = patientRepo.findByLastName(patient.getLastName());

        try{
            if(existingFirstName.isEmpty() && existingLastName.isEmpty()){
                patientRepo.save(patient);
                return ResponseEntity.status(HttpStatus.OK).body(" NEW PATIENT ADDED ");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" PATIENT ALREADY EXISTED ");
    }
}
