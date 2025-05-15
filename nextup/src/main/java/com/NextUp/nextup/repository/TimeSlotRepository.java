package com.NextUp.nextup.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.NextUp.nextup.model.TimeSlot;


public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByStaffIdAndIsBookedFalse(Long staffId);
}
