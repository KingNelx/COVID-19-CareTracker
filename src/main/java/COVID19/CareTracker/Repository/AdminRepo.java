package COVID19.CareTracker.Repository;

import COVID19.CareTracker.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface AdminRepo extends MongoRepository <Admin, String> {

    Optional <Admin> findByEmail(String email);
    Optional <Admin> findByUserName(String userName);
    Admin findByEmailAndUserNameAndPasswordAndSpecialCharacters(String email, String userName, String password, String specialCharacters);

}
