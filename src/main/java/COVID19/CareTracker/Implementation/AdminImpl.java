package COVID19.CareTracker.Implementation;

import COVID19.CareTracker.Entity.Admin;
import COVID19.CareTracker.Repository.AdminRepo;
import COVID19.CareTracker.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
@Service
public class AdminImpl implements AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Override
    public ResponseEntity <String> createAccount(@RequestBody Admin admin){
        Optional <Admin> existingUserName = adminRepo.findByAdminUserName(admin.getAdminUserName());
        Optional <Admin> existingEmail = adminRepo.findByAdminEmail(admin.getAdminEmail());

        try{
           if(existingUserName.isEmpty() && existingEmail.isEmpty()) {
               adminRepo.save(admin);
               return ResponseEntity.status(HttpStatus.OK).body(" ADMIN ACCOUNT CREATED ");
           }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING WENT WRONG " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" ACCOUNT ALREADY EXISTED ");
    }

    @Override
    public ResponseEntity <String> adminLogIn(@RequestParam String adminEmail, @RequestParam String adminUserName, @RequestParam String adminPassword){
        Admin existingAdminAccount = adminRepo.findByAdminEmailAndAdminUserNameAndAdminPassword(adminEmail, adminUserName, adminPassword);

        try{
            if(existingAdminAccount != null) {
                return ResponseEntity.status(HttpStatus.OK).body(" ADMIN SUCCESSFULLY LOG IN ");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" SOMETHING BAD HAPPEN " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" ADMIN ACCOUNT IS NOT REGISTERED ");
    }

    @Override
    public List <Admin> queryAdmins(){
        try{
            if(!adminRepo.findAll().isEmpty()){
                return adminRepo.findAll();
            }
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }

}

/*

 */
