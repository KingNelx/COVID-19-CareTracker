package COVID19.CareTracker.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.FetchType;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy =  GenerationType.TABLE)
    @Column(name = "doc_id")
    private @Getter @Setter Long id;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    private @Getter @Setter List <Patient> patientID;
}
