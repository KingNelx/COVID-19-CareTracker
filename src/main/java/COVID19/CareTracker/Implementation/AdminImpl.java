package COVID19.CareTracker.Implementation;

import COVID19.CareTracker.Entity.Admin;
import COVID19.CareTracker.Repository.AdminRepo;
import COVID19.CareTracker.Service.AdminService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AdminImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity <String> createAccount(@RequestBody Admin admin){
        Optional <Admin> existingEmail = adminRepo.findByEmail(admin.getEmail());
        Optional <Admin> existingUserName = adminRepo.findByUserName(admin.getUserName());

        try{
            if(existingEmail.isEmpty() && existingUserName.isEmpty()){
                adminRepo.save(admin);
                return ResponseEntity.status(HttpStatus.OK).body(" ADMIN ACCOUNT CREATED ");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" DATA ALREADY EXISTED");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG ");
    }

    @Override
    public ResponseEntity <String> logInAsAdmin(@RequestParam String email, @RequestParam String userName, @RequestParam String password, @RequestParam String specialCharacters){
        Admin existingAdminData = adminRepo.findByEmailAndUserNameAndPasswordAndSpecialCharacters(email, userName, password, specialCharacters);
        try{
            if(existingAdminData != null){
                return ResponseEntity.status(HttpStatus.OK).body(" LOG IN SUCCESSFULLY ");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" ACCOUNT DOES NOT EXIST ");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING BAD HAPPEN ");
    }
}
