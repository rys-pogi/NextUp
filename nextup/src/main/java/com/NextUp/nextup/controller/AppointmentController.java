import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NextUp.nextup.model.Appointment;
import com.NextUp.nextup.services.AppointmentService;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired private Appointment appointmentService;

    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(
            @RequestParam Long studentId,
            @RequestParam Long timeSlotId) {
        return ResponseEntity.ok(appointmentService.bookAppointment(studentId, timeSlotId));
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<Appointment> approve(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.approveAppointment(id));
    }

    @PostMapping("/{id}/decline")
    public ResponseEntity<Appointment> decline(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.declineAppointment(id));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<Appointment>> getStudentAppointments(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getStudentAppointments(id));
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<List<Appointment>> getStaffAppointments(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getStaffAppointments(id));
    }
}
