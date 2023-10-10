package COVID19.CareTracker.Service;

import COVID19.CareTracker.Entity.Admin;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@Service
public interface AdminService {

    // create admin account
    ResponseEntity <String> createAccount(Admin admin);

    // log in admin
    ResponseEntity <String> logInAsAdmin(String email, String userName, String password, String specialCharacters);

}
