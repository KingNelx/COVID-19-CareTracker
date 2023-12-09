package COVID19.CareTracker.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "travelhistory")
public class TravelHistory {

    @Id
    @Column(name = "travel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    @Column(name = "destination", nullable = false)
    private @Getter @Setter String destination;

    @Column(name= "departure_date", nullable = false)
    private @Getter @Setter LocalDate departureDate;

    @Column(name = "arrival_date", nullable = false)
    private @Getter @Setter LocalDate arrivalDate;

    @Column(name = "purpose_of_travel", nullable = false)
    private @Getter @Setter String purposeOfTravel;

    @Column(name = "mode_of_travel", nullable = false)
    private @Getter @Setter String modeOfTravel;

    @OneToOne()
    @JoinColumn(name = "id")
    private @Getter @Setter Patient patientID;
}
