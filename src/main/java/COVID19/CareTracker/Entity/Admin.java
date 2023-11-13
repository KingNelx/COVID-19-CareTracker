package COVID19.CareTracker.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private @Getter @Setter Long adminID;

    @Column(name = "admin_username", nullable = false)
    private @Getter @Setter String adminUserName;

    @Column(name = "admin_contact_number", nullable = false)
    private @Getter @Setter String contactNumber;

    @Column(name = "admin_email", nullable = false)
    private @Getter @Setter String adminEmail;

    @Column(name = "admin_password", nullable = false)
    private @Getter @Setter String adminPassword;
}
