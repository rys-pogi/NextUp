package com.NextUp.nextup.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User recipient;

    private String message;

    private boolean isRead;

    private LocalDateTime timestamp;

    // Getters and setters below...
}
