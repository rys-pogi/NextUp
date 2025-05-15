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

    public Object declineAppointment(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'declineAppointment'");
    }

    public Object getStudentAppointments(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentAppointments'");
    }

    public Object approveAppointment(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'approveAppointment'");
    }

    public Object bookAppointment(Long studentId, Long timeSlotId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bookAppointment'");
    }

    public TimeSlot getTimeSlot() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTimeSlot'");
    }

    public Object getStudent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudent'");
    }
}

