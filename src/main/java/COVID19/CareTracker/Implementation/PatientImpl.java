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
import org.springframework.web.bind.annotation.PathVariable;
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
        List <Patient> allPatients = patientRepo.findAll();

        try{
            if(!allPatients.isEmpty()){
                return allPatients;
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() + " SOMETHING WENT WRONG ");
        }
        throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity <String> deletePatientByID(@PathVariable Long id){
       Optional <Patient> existingID = patientRepo.findById(id);
       try{
           if(existingID.isPresent()){
               patientRepo.deleteById(id);
               return ResponseEntity.status(HttpStatus.OK).body(" PATIENT DELETED ");
           }
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getCause());
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" PATIENT DATA DOES NOT EXIST ");
    }


    @Override
    public ResponseEntity <String> updatePatientData(@PathVariable Long id, @RequestBody Patient patient){
        Patient existingPatient = patientRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        try{
            if(existingPatient != null){
                existingPatient.setFirstName(patient.getFirstName());
                existingPatient.setLastName(patient.getLastName());
                existingPatient.setAddress(patient.getAddress());
                existingPatient.setDateOfBirth(patient.getDateOfBirth());
                existingPatient.setGender(patient.getGender());
                existingPatient.setPatientType(patient.getPatientType());
                existingPatient.setPhoneNumber(patient.getPhoneNumber());
                existingPatient.setEmailAddress(patient.getEmailAddress());
                patientRepo.save(existingPatient);
                return ResponseEntity.status(HttpStatus.OK).body(" UPDATED SUCCESSFULLY ");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getCause());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" PATIENT DOES NOT EXIST ");
    }

    @Override
    public Optional <Patient> queryPatientByID(@PathVariable Long id){
        Optional <Patient> existingID = patientRepo.findById(id);

        try{
            if(existingID.isPresent()){
                return existingID;
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, " SOMETHING WENT WRONG " + e.getCause());
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @Override
    public Optional <Patient> allMalePatients(){
        Optional <Patient> allMale = patientRepo.findByGender("Male");

        try{
            if(allMale.isPresent()){
                return allMale;
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, " SOMETHING WENT WRONG " + e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Optional <Patient> allFemalePatients(){
        Optional <Patient> allFemale = patientRepo.findByGender("Female");
        try{
            if(allFemale.isPresent()){
                return allFemale;
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, " SOMETHING WENT WRONG " + e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }

}
