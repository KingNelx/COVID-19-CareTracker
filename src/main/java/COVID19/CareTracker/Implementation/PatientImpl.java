package COVID19.CareTracker.Implementation;

import COVID19.CareTracker.Entity.Doctor;
import COVID19.CareTracker.Entity.Patient;
import COVID19.CareTracker.Repository.DocRepo;
import COVID19.CareTracker.Repository.PatientRepo;
import COVID19.CareTracker.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PatientImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DocRepo docRepo;
    @Override
    public ResponseEntity<String> addPatient(@RequestBody Patient newPatient) {

        Optional <Patient> existingPatientID = patientRepo.findByPatientID(newPatient.getPatientID());
        Optional <Patient> existingFirstName = patientRepo.findByFirstName(newPatient.getFirstName());
        Optional <Patient> existingLastName = patientRepo.findByLastName(newPatient.getLastName());

       try{
           if(existingPatientID.isPresent() && existingFirstName.isPresent() && existingLastName.isPresent()){
               return ResponseEntity.status(HttpStatus.CONFLICT).body(" PATIENT ALREADY EXISTED ");
           }
           Long doctorID = newPatient.getDoctor().getId();
           Optional <Doctor> doctorOptional = docRepo.findById(doctorID);
           try{
               if(doctorOptional.isEmpty()){
                   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" DOCTOR NOT FOUND ");
               }
               Doctor doctor = doctorOptional.get();
               newPatient.setDoctor(doctor);
               Patient patient = patientRepo.save(newPatient);
               try{
                   if(patient != null){
                       return ResponseEntity.status(HttpStatus.OK).body(" NEW PATIENT ADDED ");
                   }
               }catch (Exception e){
                   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getCause());
               }
           }catch (Exception e){
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getCause());
           }
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getCause());
       }
        return null;
    }

    @Override
    public List <Patient> queryPatients(){
        try{
            if(!patientRepo.findAll().isEmpty()){
                return patientRepo.findAll();
            }else{
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() + " SOMETHING WENT WRONG ");
        }
    }
}
