package COVID19.CareTracker.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import jakarta.persistence.ElementCollection;
@Document(collection = "MedicalHistory")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class MedicalHistory {

    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    @ElementCollection
    private @Getter @Setter List <String> medicalConditions;

    @Column(nullable = false)
    @ElementCollection
    private @Getter @Setter List <String> allergies;

    @Column(nullable = false)
    private @Getter @Setter List <String> medications;
}
