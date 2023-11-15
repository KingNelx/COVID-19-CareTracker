package COVID19.CareTracker.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private @Getter @Setter Long docID;

    @Column(name = "first_name", nullable = false)
    private @Getter @Setter String firstName;

    @Column(name = "last_name", nullable = false)
    private @Getter @Setter String lastName;

    @Column(name = "gender", nullable = false)
    private @Getter @Setter String gender;

    @Column(name = "age", nullable = false)
    private @Getter @Setter int age;

    @Column(name = "email_address", nullable = false)
    private @Getter @Setter String emailAddress;

    @Column(name = "phone_number", nullable = false)
    private @Getter @Setter String phoneNumber;

    @Column(name = "address", nullable = false)
    private @Getter @Setter String address;

    @Column(name = "speciality", nullable = false)
    private @Getter @Setter String speciality;

    @Column(name = "license_number", nullable = false)
    private @Getter @Setter String licenseNumber;

    @Column(name = "years_of_experience", nullable = false)
    private @Getter @Setter String yrsOfExperience;

    @OneToMany(mappedBy = "doc_id")
    private List <Patient> patients;
}
