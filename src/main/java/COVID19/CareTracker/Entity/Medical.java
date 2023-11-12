package COVID19.CareTracker.Entity;

import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_id")
    private @Getter @Setter String medicalID;

    @Column(name = "test_type", nullable = false)
    private @Getter @Setter String testType;

    @Column(name = "result", nullable = false)
    private @Getter @Setter String result;

    @Column(name = "test_date", nullable = false)
    private @Getter @Setter Date testDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
