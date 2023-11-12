package COVID19.CareTracker.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DOCTOR")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private @Getter @Setter Long doctorID;

    @Column(name = "first_name", nullable = false)
    private @Getter @Setter String firstName;

    @Column(name = "last_name", nullable = false)
    private @Getter @Setter String lastName;

    @Column(name = "email", nullable = false)
    private @Getter @Setter String email;

    @Column(name = "phone_number", nullable = false)
    private @Getter @Setter String phoneNumber;

    @Column(name = "specialization", nullable = false)
    private @Getter @Setter String specialization;

    @Column(name = "license_Number", nullable = false)
    private @Getter @Setter String licenseNumber;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List <Patient> patients;
}
