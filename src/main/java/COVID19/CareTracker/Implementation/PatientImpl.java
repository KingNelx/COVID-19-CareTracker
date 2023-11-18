package COVID19.CareTracker.Implementation;

import COVID19.CareTracker.Entity.Doctor;
import COVID19.CareTracker.Entity.Patient;
import COVID19.CareTracker.Repository.DocRepo;
import COVID19.CareTracker.Repository.PatientRepo;
import COVID19.CareTracker.Service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PatientImpl implements PatientService {
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private DocRepo docRepo;
    @Override
    public ResponseEntity <String> addNewPatient(@RequestBody Patient patient){
        Optional <Patient> existingFirstName = patientRepo.findByFirstName(patient.getFirstName());
        Optional <Patient> existingLastName = patientRepo.findByLastName(patient.getLastName());
        Optional <Patient> existingPatientID = patientRepo.findByPatientID(patient.getPatientID());
        Optional<Doctor> existingDoctor = docRepo.findById(patient.getDoctor().getId());

        try{
            if(existingFirstName.isPresent() && existingLastName.isPresent() && existingPatientID.isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("PATIENT DATA ALREADY EXISTS");
            }else{
                if(existingDoctor.isPresent()){
                    Doctor doctor = existingDoctor.get();
                    patientRepo.save(patient);
                    patient.setDoctor(doctor);
                    return ResponseEntity.status(HttpStatus.OK).body("NEW PATIENT ADDED");
                }else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DOCTOR NOT FOUND");
                }
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getCause());
        }

    }

    @Override
    public List <Patient> queryPatients(){
        try{
            if(!patientRepo.findAll().isEmpty()){
                return patientRepo.findAll();
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, " SOMETHING WENT WRONG " + e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.NO_CONTENT, " NO DATA FOUND ");
    }
}
