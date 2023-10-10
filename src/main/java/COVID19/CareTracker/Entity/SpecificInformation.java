package COVID19.CareTracker.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "SpecificInformation")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class SpecificInformation {

    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    @ElementCollection
    private @Getter @Setter List <String> diagnosis;

    @Column(nullable = false)
    @ElementCollection
    private @Getter @Setter List <String> testResult;

    @Column(nullable = false)
    @ElementCollection
    private @Getter @Setter List <String> severityOfSymptoms;

    @Column(nullable = false)
    @ElementCollection
    private @Getter @Setter List <String> healthStatus;

    @Column(nullable = false)
    @ElementCollection
    private @Getter @Setter List <String> treatmentDetails;


}
