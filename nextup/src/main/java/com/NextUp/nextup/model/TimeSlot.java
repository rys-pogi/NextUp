package com.NextUp.nextup.model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;



@Entity
public class TimeSlot {
    @Id @GeneratedValue
    private Long id;


    @ManyToOne
    private User staff; // Only staff can have timeslots

    public boolean isBooked() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isBooked'");
    }

    public User getStaff() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStaff'");
    }

    public void setBooked(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBooked'");
    }

    public void setDate(LocalDate date2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDate'");
    }

    public void setStartTime(Object staff2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStartTime'");
    }

    public Long getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

}
