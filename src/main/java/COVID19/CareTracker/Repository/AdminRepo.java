package COVID19.CareTracker.Repository;

import COVID19.CareTracker.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository <Admin, Long> {
    Optional <Admin> findByAdminUserName(String adminUserName);
    Optional <Admin> findByAdminEmail(String adminEmail);
    Admin findByAdminEmailAndAdminUserNameAndAdminPassword(String adminEmail, String userName, String adminPassword);
}
