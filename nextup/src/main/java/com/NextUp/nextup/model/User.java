import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


package com.NextUp.nextup.model;

import javax.annotation.processing.Generated;

import org.apache.commons.math3.analysis.function.Identity;

public class User {
    @Id @Generated
    private Long id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Getters and setters
}

