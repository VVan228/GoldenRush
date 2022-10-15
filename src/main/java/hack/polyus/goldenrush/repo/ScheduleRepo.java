package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {

    Schedule getScheduleByDate(Date time);

    Schedule getScheduleById(Long id);
}
