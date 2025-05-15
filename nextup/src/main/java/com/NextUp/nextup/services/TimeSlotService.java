import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class TimeSlotService {
    @Autowired private TimeSlotRepository timeSlotRepo;
    @Autowired private UserRepository userRepo;

    public List<TimeSlot> getAvailableTimeSlots(Long staffId) {
        return timeSlotRepo.findByStaffIdAndIsBookedFalse(staffId);
    }

    public TimeSlot createTimeSlot(Long staffId, LocalDate date, LocalTime start, LocalTime end) {
        User staff = userRepo.findById(staffId).orElseThrow();
        TimeSlot ts = new TimeSlot();
        ts.setDate(date);
        ts.setStartTime(start);
        ts.setEndTime(end);
        ts.setStaff(staff);
        ts.setBooked(false);
        return timeSlotRepo.save(ts);
    }
}
