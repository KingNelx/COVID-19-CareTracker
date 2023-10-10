package COVID19.CareTracker.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "BasicInformation")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class BasicInformation {

    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String firstName;

    @Column(nullable = false)
    private @Getter @Setter String lastName;

    @Column(nullable = false)
    private @Getter @Setter String middleName;

    @Column(nullable = false)
    private @Getter @Setter LocalDate dateOfBirth;

    @Column(nullable = false)
    private @Getter @Setter String address;

    @Column(nullable = false)
    private @Getter @Setter String phoneNumber;

    @Column(nullable = false)
    private @Getter @Setter String email;

    @DBRef
    private @Getter @Setter SpecificInformation specificInformation;

    @DBRef
    private @Getter @Setter MedicalHistory medicalHistory;

    @DBRef
    private @Getter @Setter TravelHistory travelHistory;
}
