package COVID19.CareTracker.Service;

import COVID19.CareTracker.Entity.BasicInformation;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@Service
public interface BasicInfoService {

    // add patient
    ResponseEntity <String> addPatient(BasicInformation basicInformation);

    // view patients
    List <BasicInformation> getPatients();

    // get patient by id
    Optional <BasicInformation> getPatientByID(String id);

    // update patient data
    ResponseEntity <String> updatePatientData(String id, BasicInformation basicInformation);

    // delete patient data
    ResponseEntity <String> deletePatientData(String id);

    // get all male patients
    List <BasicInformation> getAllMalePatients();


    //get all female patients
    List <BasicInformation> getAllFemalePatients();

}
