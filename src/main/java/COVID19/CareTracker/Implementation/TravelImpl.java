package COVID19.CareTracker.Implementation;

import COVID19.CareTracker.Entity.Patient;
import COVID19.CareTracker.Entity.TravelHistory;
import COVID19.CareTracker.Repository.PatientRepo;
import COVID19.CareTracker.Repository.TravelRepo;
import COVID19.CareTracker.Service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TravelImpl implements TravelService {

    @Autowired
    private TravelRepo travelRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Override
    public ResponseEntity <String> addTravelHistory(@RequestBody TravelHistory travelHistory){
        Long patientID = travelHistory.getPatientID().getId();
        Optional <Patient> patient = patientRepo.findById(patientID);

        try{
            if(patient.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" PATIENT NOT FOUND ");
            }
            Patient patientData = patient.get();
            travelHistory.setPatientID(patientData);
            TravelHistory travel = travelRepo.save(travelHistory);
            try{
                if(travel != null){
                    return ResponseEntity.status(HttpStatus.OK).body(" TRAVEL HISTORY ADDED ");
                }
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getCause());
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" ADD THE LATEST TRAVEL ONLY FOR EACH PATIENT " + e.getCause());
        }
        return null;
    }

    @Override
    public List <TravelHistory> queryHistory(){
        List <TravelHistory> allHistory = travelRepo.findAll();
        try{
            if(!allHistory.isEmpty()){
                return allHistory;
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }
}
