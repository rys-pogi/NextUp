package com.NextUp.nextup.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.NextUp.nextup.model.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByStudentId(Long studentId);
    List<Appointment> findByStaffId(Long staffId);
}
