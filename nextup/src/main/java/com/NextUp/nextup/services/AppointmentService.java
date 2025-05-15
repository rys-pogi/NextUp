import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.NextUp.nextup.model.Appointment;
import com.NextUp.nextup.model.TimeSlot;
import com.NextUp.nextup.repository.AppointmentRepository;
import com.NextUp.nextup.repository.TimeSlotRepository;
import com.NextUp.nextup.repository.UserRepository;
import com.NextUp.nextup.model.User;

@Service
public class AppointmentService {
    @Autowired private AppointmentRepository appointmentRepo;
    @Autowired private TimeSlotRepository timeSlotRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private NotificationService notificationService;

    public Appointment bookAppointment(Long studentId, Long timeSlotId) {
        TimeSlot ts = timeSlotRepo.findById(timeSlotId).orElseThrow();
        if (ts.isBooked()) throw new IllegalStateException("Time slot already booked");

        User student = userRepo.findById(studentId).orElseThrow();
        User staff = ts.getStaff();

        Appointment appt = new Appointment();
        appt.setStudent(student);
        appt.setStaff(staff);
        appt.setTimeSlot(ts);
        appt.setStatus("PENDING");
        appt.setCreatedAt(LocalDateTime.now());

        ts.setBooked(true);
        timeSlotRepo.save(ts);
        Appointment saved = appointmentRepo.save(appt);

        NotificationService.send(staff, "New appointment request from " + student.getName());

        return saved;
    }

    public Appointment approveAppointment(Long appointmentId) {
        Appointment appt = appointmentRepo.findById(appointmentId).orElseThrow();
        appt.setStatus("APPROVED");
        appointmentRepo.save(appt);

        notificationService.send(appt.getStudent(), "Your appointment with " + appt.getStaff().getName() + " has been approved.");
        return appt;
    }

    public Appointment declineAppointment(Long appointmentId) {
        Appointment appt = appointmentRepo.findById(appointmentId).orElseThrow();
        appt.setStatus("DECLINED");
        appt.getTimeSlot().setBooked(false); // Free the time slot
        appointmentRepo.save(appt);

        notificationService.send(appt.getStudent(), "Your appointment has been declined.");
        return appt;
    }

    public List<Appointment> getStudentAppointments(Long studentId) {
        return appointmentRepo.findByStudentId(studentId);
    }

    public List<Appointment> getStaffAppointments(Long staffId) {
        return appointmentRepo.findByStaffId(staffId);
    }
}
