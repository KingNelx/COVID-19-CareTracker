package COVID19.CareTracker.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Patient")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private @Getter @Setter Long id;

    @Column(name = "patient_id", nullable = false)
    private @Getter @Setter String patientID;

    @Column(name = "first_name", nullable = false)
    private @Getter @Setter String firstName;

    @Column(name = "last_name", nullable = false)
    private @Getter @Setter String lastName;

    @Column(name = "address", nullable = false)
    private @Getter @Setter String address;

    @Column(name = "date_of_birth", nullable = false)
    private @Getter @Setter String dateOfBirth;

    @Column(name = "gender", nullable = false)
    private @Getter @Setter String gender;

    @Column(name = "phone_number", nullable = false)
    private @Getter @Setter String phoneNumber;

    @Column(name = "email_address", nullable = false)
    private @Getter @Setter String emailAddress;

    @ManyToOne()
    @JoinColumn(name = "doc_id")
    private @Getter @Setter Doctor doctor;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "patientID", cascade = CascadeType.ALL)
    private @Getter @Setter TravelHistory travelHistory;

}
