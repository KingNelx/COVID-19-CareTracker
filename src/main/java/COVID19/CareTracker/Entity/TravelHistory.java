package COVID19.CareTracker.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Generated;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRAVELHISTORY")
public class TravelHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_id")
    private @Getter @Setter Long travelID;

    @Column(name = "country_visited", nullable = false)
    private @Getter @Setter String countryVisited;

    @Column(name = "city_visited", nullable = false)
    private @Getter @Setter String cityVisited;

    @Column(name = "arrival_date", nullable = false)
    private @Getter @Setter LocalDate arrivalDate;

    @Column(name = "departure_date", nullable = false)
    private @Getter @Setter LocalDate departureDate;

    @Column(name = "mode_of_transport", nullable = false)
    private @Getter @Setter String modeOfTransport;

    @Column(name = " purpose_of_travel", nullable = false)
    private @Getter @Setter String purposeOfTravel;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
