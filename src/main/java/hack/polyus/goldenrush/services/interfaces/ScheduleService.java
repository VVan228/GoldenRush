package hack.polyus.goldenrush.services.interfaces;

import hack.polyus.goldenrush.models.schedule.Schedule;

import java.time.LocalDateTime;
import java.util.Date;

public interface ScheduleService {

    Schedule getSchedule(Date date);

    void updateSchedule(Long id);
}
