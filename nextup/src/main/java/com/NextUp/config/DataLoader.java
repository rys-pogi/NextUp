package com.NextUp.config;


import com.NextUp.nextup.model.Role;
import com.NextUp.nextup.model.TimeSlot;
import com.NextUp.nextup.model.User;
import com.NextUp.nextup.repository.UserRepository;
import com.NextUp.nextup.services.AppointmentService;
import com.NextUp.nextup.services.TimeSlotService;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired private UserRepository userRepository;
    @Autowired private TimeSlotService timeSlotService;
    @Autowired private AppointmentService appointmentService;

    @Override
    public void run(String... args) {
        // Create Staff
        User staff = new User();
        staff.setName("Prof. Renz");
        staff.setEmail("staff@example.com");
        staff.setPassword("password"); // use encoder in real setup
        staff.setRole(Role.STAFF);
        userRepository.save(staff);

        // Create Student
        User student = new User();
        student.setName("Jarom");
        student.setEmail("student@example.com");
        student.setPassword("password");
        student.setRole(Role.STUDENT);
        userRepository.save(student);

        // Create Time Slots
        LocalDate today = LocalDate.now();
        LocalTime startTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(10, 30);
        timeSlotService.createTimeSlot(staff.getId(), today.plusDays(1), startTime, endTime);
        timeSlotService.createTimeSlot(staff.getId(), today.plusDays(1), LocalTime.of(11, 0), LocalTime.of(11, 30));

        // Student books an appointment
        TimeSlot availableSlot = timeSlotService.getAvailableTimeSlots(staff.getId()).get(0);
        appointmentService.bookAppointment(student.getId(), availableSlot.getId());
    }
}
