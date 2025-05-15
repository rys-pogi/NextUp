package com.NextUp.nextup.repository;

import com.NextUp.nextup.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipientIdOrderByTimestampDesc(Long recipientId);
}
