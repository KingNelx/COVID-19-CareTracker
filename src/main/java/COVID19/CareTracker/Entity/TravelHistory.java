package COVID19.CareTracker.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TravelHistory")
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class TravelHistory {

    @Id
    private @Getter @Setter String id;

    @Column(nullable = false)
    private @Getter @Setter String travelDestination;

    @Column(nullable = false)
    private @Getter @Setter String departureDate;

    @Column(nullable = false)
    private @Getter @Setter String arrivalDate;

    @Column(nullable = false)
    private @Getter @Setter String modeOfTravel;

    @Column(nullable = false)
    private @Getter @Setter String purposeOfTravel;
}
