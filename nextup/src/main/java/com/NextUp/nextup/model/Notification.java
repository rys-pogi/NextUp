import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Entity
public class Notification {
    @Id @GeneratedValue
    private Long id;

    private String message;
    private boolean isRead = false;

    @ManyToOne
    private User recipient;

    private LocalDateTime timestamp = LocalDateTime.now();
}
