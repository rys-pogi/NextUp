import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Entity
public class TimeSlot {
    @Id @GeneratedValue
    private Long id;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    private boolean isBooked = false;

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
}
