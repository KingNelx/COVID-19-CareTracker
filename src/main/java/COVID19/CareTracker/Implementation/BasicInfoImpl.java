package COVID19.CareTracker.Implementation;

import COVID19.CareTracker.Entity.BasicInformation;
import COVID19.CareTracker.Entity.MedicalHistory;
import COVID19.CareTracker.Entity.SpecificInformation;
import COVID19.CareTracker.Entity.TravelHistory;
import COVID19.CareTracker.Repository.BasicInfoRepo;
import COVID19.CareTracker.Repository.MedicalHistoryRepo;
import COVID19.CareTracker.Repository.SpecificRepo;
import COVID19.CareTracker.Repository.TravelHistoryRepo;
import COVID19.CareTracker.Service.BasicInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;
import java.util.List;

@Service
@AllArgsConstructor
public class BasicInfoImpl implements BasicInfoService {

    @Autowired
    private BasicInfoRepo basicInfoRepo;

    @Autowired
    private SpecificRepo specificRepo;

    @Autowired
    private MedicalHistoryRepo medicalHistoryRepo;

    @Autowired
    private TravelHistoryRepo travelHistoryRepo;

    @Override
    public ResponseEntity <String> addPatient(@RequestBody BasicInformation basicInformation){
        SpecificInformation specificInformation = basicInformation.getSpecificInformation();
        MedicalHistory medicalHistory = basicInformation.getMedicalHistory();
        TravelHistory travelHistory = basicInformation.getTravelHistory();
        Optional <BasicInformation> existingPatientInfo = basicInfoRepo.findById(basicInformation.getId());

        try{
            if(existingPatientInfo.isEmpty()){
                if(specificInformation.getId() == null && medicalHistory.getId() == null && travelHistory.getId() == null){
                    specificRepo.save(specificInformation);
                    medicalHistoryRepo.save(medicalHistory);
                    travelHistoryRepo.save(travelHistory);
                    basicInfoRepo.save(basicInformation);
                    return ResponseEntity.status(HttpStatus.OK).body(" PATIENT ADDED ");
                }
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage() + " PATIENT ALREADY EXISTED ");
        }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG ");
    }

    @Override
    public List <BasicInformation> getPatients(){
        try{
            if(!basicInfoRepo.findAll().isEmpty()){
                return basicInfoRepo.findAll();
            }
        }catch(Exception e){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT, e.getMessage());
        }
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, " SOMETHING WENT WRONG ");
    }

    @Override
    public Optional <BasicInformation> getPatientByID(@PathVariable String id){
        try{
            if(basicInfoRepo.findById(id).isPresent()){
                return basicInfoRepo.findById(id);
            }
        }catch(Exception e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, e.getMessage());
            }
        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR , " SOMETHING WENT WRONG");
        }


    @Override
    public ResponseEntity <String> updatePatientData(@PathVariable String id, @RequestBody BasicInformation basicInformation){

        BasicInformation basicInformationData = basicInfoRepo.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        try{
            if(basicInformation != null){
                basicInformationData.setFirstName(basicInformation.getFirstName());
                basicInformationData.setLastName(basicInformation.getLastName());
                basicInformationData.setMiddleName(basicInformation.getMiddleName());
                basicInformationData.setGender(basicInformation.getGender());
                basicInformationData.setDateOfBirth(basicInformation.getDateOfBirth());
                basicInformationData.setAddress(basicInformation.getAddress());
                basicInformationData.setPhoneNumber(basicInformation.getPhoneNumber());
                basicInformationData.setEmail(basicInformation.getEmail());


                SpecificInformation specificInformation = basicInformation.getSpecificInformation();

                if(specificInformation.getId() != null ){
                    specificInformation.setDiagnosis(basicInformation.getSpecificInformation().getDiagnosis());
                    specificInformation.setTestResult(basicInformation.getSpecificInformation().getTestResult());
                    specificInformation.setSeverityOfSymptoms(basicInformation.getSpecificInformation().getSeverityOfSymptoms());
                    specificInformation.setHealthStatus(basicInformation.getSpecificInformation().getHealthStatus());
                    specificInformation.setTreatmentDetails(basicInformation.getSpecificInformation().getTreatmentDetails());
                }

                MedicalHistory medicalHistory = basicInformation.getMedicalHistory();
                if(medicalHistory.getId() != null){
                    medicalHistory.setMedicalConditions(basicInformation.getMedicalHistory().getMedicalConditions());
                    medicalHistory.setAllergies(basicInformation.getMedicalHistory().getAllergies());
                    medicalHistory.setMedications(basicInformation.getMedicalHistory().getMedications());
                }

                TravelHistory travelHistory = basicInformation.getTravelHistory();
                if(travelHistory.getId() != null){
                    travelHistory.setTravelDestination(basicInformation.getTravelHistory().getTravelDestination());
                    travelHistory.setDepartureDate(basicInformation.getTravelHistory().getDepartureDate());
                    travelHistory.setArrivalDate(basicInformation.getTravelHistory().getArrivalDate());
                    travelHistory.setModeOfTravel(basicInformation.getTravelHistory().getModeOfTravel());
                    travelHistory.setPurposeOfTravel(basicInformation.getTravelHistory().getPurposeOfTravel());
                }

                basicInfoRepo.save(basicInformationData);
                specificRepo.save(specificInformation);
                medicalHistoryRepo.save(medicalHistory);
                travelHistoryRepo.save(travelHistory);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" PATIENT DATA MISSING " + e.getMessage());
        }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG ");
    }

    @Override
    public ResponseEntity <String> deletePatientData(@PathVariable String id){
        Optional <BasicInformation> dataHandler = basicInfoRepo.findById(id);
        try{
            if(dataHandler.isPresent()){
                BasicInformation basicInformation = dataHandler.get();
                specificRepo.deleteById(basicInformation.getSpecificInformation().getId());
                medicalHistoryRepo.deleteById(basicInformation.getMedicalHistory().getId());
                travelHistoryRepo.deleteById(basicInformation.getTravelHistory().getId());
                return ResponseEntity.status(HttpStatus.OK).body(" PATIENT DATA DELETED ");
            }
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" PATIENT DATA MISSING " + e.getMessage());
        }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG ");
    }

    @Override
    public List <BasicInformation> getAllMalePatients(){
        try{
            if(!basicInfoRepo.findByGender("MALE").isEmpty()){
                return basicInfoRepo.findByGender("MALE");
            }
        }catch(Exception e){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT, e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, " SOMETHING WENT WRONG ");
    }

    @Override
    public List <BasicInformation> getAllFemalePatients(){
        try{
            if(!basicInfoRepo.findByGender("FEMALE").isEmpty()){
                return basicInfoRepo.findByGender("FEMALE");
            }
        }catch(Exception e){
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT, e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, " SOMETHING WENT WRONG ");
    }
}
