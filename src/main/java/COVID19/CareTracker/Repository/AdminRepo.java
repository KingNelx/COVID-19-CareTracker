package COVID19.CareTracker.Repository;


import COVID19.CareTracker.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdminRepo extends MongoRepository <Admin, String> {

    Optional <Admin> findByAdminID(String id);
    Optional <Admin> findByEmail(String email);
    Optional <Admin> findByUserName(String userName);
    Optional <Admin> findByPassword(String password);
}
