package com.NextUp.nextup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.NextUp.nextup.services.*;
import com.NextUp.nextup.model.TimeSlot;

@RestController
@RequestMapping("/api/timeslots")
public class TimeSlotController {

    @Autowired private TimeSlotService timeSlotService;

    @PostMapping("/staff/{staffId}")
    public ResponseEntity<TimeSlot> createSlot(
            @PathVariable Long staffId,
            @RequestBody TimeSlotRequest request) {
        TimeSlot slot = timeSlotService.createTimeSlot(
                staffId, request.getDate(), request.getStartTime(), request.getEndTime());
        return ResponseEntity.ok(slot);
    }

    @GetMapping("/available/{staffId}")
    public ResponseEntity<List<TimeSlot>> getAvailableSlots(@PathVariable Long staffId) {
        return ResponseEntity.ok(timeSlotService.getAvailableTimeSlots(staffId));
    }

    @Data
    static class TimeSlotRequest {
        @SuppressWarnings("unused")
        private LocalDate date;
        @SuppressWarnings("unused")
        private LocalTime startTime;
        @SuppressWarnings("unused")
        private LocalTime endTime;
        public LocalDate getDate() {

            throw new UnsupportedOperationException("Unimplemented method 'getDate'");
        }
        public LocalTime getEndTime() {
    
            throw new UnsupportedOperationException("Unimplemented method 'getEndTime'");
        }
        public LocalTime getStartTime() {

            throw new UnsupportedOperationException("Unimplemented method 'getStartTime'");
        }
    }
}
