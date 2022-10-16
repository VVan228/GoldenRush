package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {

    Schedule getScheduleByDateAndNightShift(LocalDate date, boolean nightShift);

    Schedule getScheduleById(Long id);
}
