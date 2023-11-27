package COVID19.CareTracker.Implementation;

import COVID19.CareTracker.Entity.Doctor;
import COVID19.CareTracker.Entity.Patient;
import COVID19.CareTracker.Repository.DocRepo;
import COVID19.CareTracker.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
@Service
public class DoctorImpl implements DoctorService {
    @Autowired
    private DocRepo docRepo;
    @Override
    public ResponseEntity <String> createDoctor(@RequestBody Doctor doctor) {
        Optional <Doctor> existingFirstName = docRepo.findByFirstName(doctor.getFirstName());
        Optional <Doctor> existingLastName = docRepo.findByLastName(doctor.getLastName());

       try{
           if(existingFirstName.isEmpty() && existingLastName.isEmpty()){
               docRepo.save(doctor);
               return ResponseEntity.status(HttpStatus.OK).body(" NEW ACCOUNT CREATED ");
           }
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getMessage());
       }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" ACCOUNT ALREADY EXISTING ");
    }

    @Override
    public List <Doctor> queryDoctors(){
       try{
           List <Doctor> allDoctors = docRepo.findAll();
           if(allDoctors.isEmpty()){
               throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
           }
           return  allDoctors;
       }catch (Exception e){
           throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong: " + e.getMessage());
       }
    }

    @Override
    public Optional <Doctor> queryDoctorByID(@PathVariable String id){
        try{
            if(docRepo.findById(Long.valueOf(id)).isPresent()){
                return docRepo.findById(Long.valueOf(id));
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, " SOMETHING WENT WRONG " + e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity <String> updateDoctorsData(@PathVariable String id, @RequestBody Doctor doctor){
        Doctor existingData = docRepo.findById(Long.valueOf(id)).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        try{
            if(existingData != null){
                existingData.setFirstName(doctor.getFirstName());
                existingData.setLastName(doctor.getLastName());
                existingData.setGender(doctor.getGender());
                existingData.setAge(doctor.getAge());
                existingData.setEmailAddress(doctor.getEmailAddress());
                existingData.setPhoneNumber(doctor.getPhoneNumber());
                existingData.setAddress(doctor.getAddress());
                existingData.setSpeciality(doctor.getSpeciality());
                existingData.setLicenseNumber(doctor.getLicenseNumber());
                existingData.setYrsOfExperience(doctor.getYrsOfExperience());
                docRepo.save(existingData);
                return ResponseEntity.status(HttpStatus.OK).body(" DATA UPDATED SUCCESSFULLY ");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" DATA DOES NOT EXIST ");
    }

    @Override
    public ResponseEntity <String> removeDoctorsData(@PathVariable String id){
        try{
            if(docRepo.findById(Long.valueOf(id)).isPresent()){
                docRepo.deleteById(Long.valueOf(id));
                return ResponseEntity.status(HttpStatus.OK).body(" DOCTOR'S DATA DELETED SUCCESSFULLY ");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" DATA DOES NOT EXIST ");
    }
}
