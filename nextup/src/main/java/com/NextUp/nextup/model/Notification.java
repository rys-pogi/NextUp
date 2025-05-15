package com.NextUp.nextup.model;

import jakarta.persistence.*;


@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User recipient;

    // Getters and setters below...
}
