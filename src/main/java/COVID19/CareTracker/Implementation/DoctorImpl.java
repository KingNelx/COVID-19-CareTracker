package COVID19.CareTracker.Implementation;

import COVID19.CareTracker.Entity.Doctor;
import COVID19.CareTracker.Repository.DoctorRepo;
import COVID19.CareTracker.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;
import java.util.List;
@Service
public class DoctorImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public ResponseEntity <String> doctorRegister(@RequestBody Doctor doctor){
        Optional <Doctor> existingFirstName = doctorRepo.findByFirstName(doctor.getFirstName());
        Optional <Doctor> existingLastName = doctorRepo.findByLastName(doctor.getLastName());

        try{
            if(existingLastName.isEmpty() && existingFirstName.isEmpty()){
                doctorRepo.save(doctor);
                return ResponseEntity.status(HttpStatus.OK).body(" DOCTORS ACCOUNT REGISTERED ");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" DOCTOR'S ACCOUNT ALREADY EXISTED ");
    }

    @Override
    public List <Doctor> queryDoctors(){
        try{
            if(!doctorRepo.findAll().isEmpty()){
                return doctorRepo.findAll();
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    }
}
