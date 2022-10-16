package hack.polyus.goldenrush.services.interfaces;

import hack.polyus.goldenrush.models.schedule.Schedule;
import hack.polyus.goldenrush.models.transport.Request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ScheduleService {

    Schedule getSchedule(LocalDate date);

    void updateSchedule(Long id);

    List<Request> getRequestsDriver(LocalDate date, Long id);

    void generateSchedule();
}
