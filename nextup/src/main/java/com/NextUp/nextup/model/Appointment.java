package com.NextUp.nextup.model;

import javax.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User student;

    @ManyToOne
    private User staff;

    @OneToOne
    private TimeSlot timeSlot;

    private String status; // PENDING, APPROVED, DECLINED, CANCELLED

    private LocalDateTime createdAt = LocalDateTime.now();

    public void setStudent(User student2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStudent'");
    }

    public void setStaff(User staff2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStaff'");
    }

    public void setTimeSlot(TimeSlot ts) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTimeSlot'");
    }

    public void setStatus(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
    }

    public void setCreatedAt(LocalDateTime now) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCreatedAt'");
    }
}

