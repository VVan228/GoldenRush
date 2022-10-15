package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.schedule.Schedule;
import hack.polyus.goldenrush.repo.ScheduleRepo;
import hack.polyus.goldenrush.services.interfaces.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    ScheduleRepo scheduleRepo;

    @Autowired
    ScheduleServiceImpl(ScheduleRepo scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }


    @Override
    public Schedule getSchedule(LocalDateTime date) {
        return scheduleRepo.getScheduleByDate(date);
    }

    @Override
    public void updateSchedule(Long id) {
        Schedule schedule = scheduleRepo.getScheduleById(id);
        scheduleRepo.save(schedule);
    }
}
