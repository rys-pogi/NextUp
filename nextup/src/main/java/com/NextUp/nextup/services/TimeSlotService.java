package com.NextUp.nextup.services;

import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.NextUp.nextup.model.TimeSlot;
import com.NextUp.nextup.model.User;
import com.NextUp.nextup.repository.TimeSlotRepository;


@Service
public class TimeSlotService {
    @Autowired private TimeSlotRepository timeSlotRepo;
    public List<TimeSlot> getAvailableTimeSlots(Long staffId) {
        return timeSlotRepo.findByStaffIdAndIsBookedFalse(staffId);
    }

    public TimeSlot createTimeSlot(Long staffId, LocalDate date, LocalTime start, LocalTime end) {
        Object staff = User.findById(staffId);
        TimeSlot ts = new TimeSlot();
        ts.setDate(date);
        ts.setStartTime(start);
        ts.setStartTime(end);
        ts.setStartTime(staff);
        ts.setBooked(false);
        return timeSlotRepo.save(ts);
    }
}
