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
    private @Getter @Setter int admin_id;

    @Column(name = "admin_user", nullable = false)
    private @Getter @Setter String admin_user;

    @Column(name = "admin_email", nullable = false)
    private @Getter @Setter String admin_email;

    @Column(name = "admin_password", nullable = false)
    private @Getter @Setter String admin_password;

    @Column(name = "admin_contact", nullable = false)
    private @Getter @Setter String admin_contact;

    @Column(name = "admin_special_char", nullable = false)
    private @Getter @Setter String admin_special_char;
}
