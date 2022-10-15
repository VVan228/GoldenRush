package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {

    Schedule getScheduleByDate(LocalDateTime time);

    Schedule getScheduleById(Long id);
}
