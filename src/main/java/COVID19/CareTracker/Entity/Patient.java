package COVID19.CareTracker.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PATIENT")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private @Getter @Setter Long patient_id;

    @Column(name = "patient_firstname",nullable = false)
    private @Getter @Setter String firstName;

    @Column(name = "patient_lastname", nullable = false)
    private @Getter @Setter String lastName;

    @Column(name = "patient_address", nullable = false)
    private @Getter @Setter String address;

    @Column(name = "patient_contact", nullable = false)
    private @Getter @Setter String contactNumber;

    @Column(name = "patient_age", nullable = false)
    private @Getter @Setter String age;

    @Column(name = "patient_gender", nullable = false)
    private @Getter @Setter String gender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private TravelHistory travelHistory;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List <Medical> medicals;

}
