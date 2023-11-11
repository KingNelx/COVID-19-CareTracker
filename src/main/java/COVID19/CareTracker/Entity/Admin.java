package COVID19.CareTracker.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ADMIN")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private @Getter @Setter Long adminID;

    @Column(name = "admin_user", nullable = false)
    private @Getter @Setter String adminUser;

    @Column(name = "admin_email", nullable = false)
    private @Getter @Setter String adminEmail;

    @Column(name = "admin_password", nullable = false)
    private @Getter @Setter String adminPassword;

    @Column(name = "admin_contact", nullable = false)
    private @Getter @Setter String adminContact;

    @Column(name = "admin_special_char", nullable = false)
    private @Getter @Setter String adminSpecialCharacter;
}
