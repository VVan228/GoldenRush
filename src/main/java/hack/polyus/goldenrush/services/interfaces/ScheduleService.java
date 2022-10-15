package hack.polyus.goldenrush.services.interfaces;

import hack.polyus.goldenrush.models.schedule.Schedule;

import java.time.LocalDateTime;

public interface ScheduleService {

    Schedule getSchedule(LocalDateTime date);

    void updateSchedule(Long id);
}
