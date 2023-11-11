package COVID19.CareTracker.Service;

import COVID19.CareTracker.Entity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.List;
@Service
public interface AdminService {

    ResponseEntity <String> createAdminAccount(Admin admin);
    ResponseEntity <String> logInAsAdmin(String email, String user, String password, String specialCharacters);
    List <Admin> queryAdmins();
}
