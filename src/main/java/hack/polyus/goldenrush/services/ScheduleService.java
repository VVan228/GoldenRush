package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.schedule.Schedule;

import java.time.LocalDateTime;

public interface ScheduleService {

    Schedule getSchedule(LocalDateTime date);

    void updateSchedule(Long id);
}
