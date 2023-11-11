package COVID19.CareTracker.Entity;


import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "Admin")
@AllArgsConstructor
@NoArgsConstructor

public class Admin {

    @Id
    private @Getter @Setter String id;

    @NonNull
    @Column(unique = true, nullable = false)
    private @Getter @Setter String adminID;

    @NonNull
    @Column(nullable = false)
    private @Getter @Setter String firstName;

    @NonNull
    @Column(nullable = false)
    private @Getter @Setter String lastName;

    @NonNull
    @Column(nullable = false)
    private @Getter @Setter String gender;

    @NonNull
    @Column(unique = true, nullable = false)
    private @Getter @Setter String email;

    @NonNull
    @Column(unique = true, nullable = false)
    private @Getter @Setter String userName;

    @Column(unique = true, nullable = false)
    private @Getter @Setter String password;
}
