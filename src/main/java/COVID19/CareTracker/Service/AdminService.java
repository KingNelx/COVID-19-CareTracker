package COVID19.CareTracker.Service;

import COVID19.CareTracker.Entity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.List;
@Service
public interface AdminService {

    ResponseEntity <String> createAccount(Admin admin);
    ResponseEntity <String> adminLogIn(String email, String userName, String password);
    List <Admin> queryAdmins();
}
