import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.NextUp.nextup.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipientIdOrderByTimestampDesc(Long userId);
}
