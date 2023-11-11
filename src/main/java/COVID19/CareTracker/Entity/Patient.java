package COVID19.CareTracker.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "Patient")
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Patient {

    @Id
    private @Getter @Setter String id;

    @NonNull
    @Column(unique = true, nullable = false)
    private @Getter @Setter String patientID;

    @NonNull
    @Column(nullable = false)
    private @Getter @Setter String firstName;

    @NonNull
    @Column(nullable = false)
    private @Getter @Setter String lastName;

    @NonNull
    @Column(nullable = false)
    private @Getter @Setter String middleName;

    @NonNull
    @Column(nullable = false)
    private @Getter @Setter String gender;

    @NonNull
    @Column(nullable = false)
    private @Getter @Setter LocalDate dateOfBirth;

    @NonNull
    @Column(nullable = false)
    private @Getter @Setter String address;

    @NonNull
    @Column(unique = true, nullable = false)
    private @Getter @Setter String email;
}
