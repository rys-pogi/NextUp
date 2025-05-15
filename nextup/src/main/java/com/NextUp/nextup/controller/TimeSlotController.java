import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;


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
        private LocalDate date;
        private LocalTime startTime;
        private LocalTime endTime;
    }
}
