package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.adapters.ErpAdapter;
import hack.polyus.goldenrush.models.schedule.Schedule;
import hack.polyus.goldenrush.models.schedule.TimeLine;
import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.models.transport.Transport;
import hack.polyus.goldenrush.repo.ScheduleRepo;
import hack.polyus.goldenrush.services.interfaces.MessagingService;
import hack.polyus.goldenrush.services.interfaces.RequestService;
import hack.polyus.goldenrush.services.interfaces.ScheduleGenerator;
import hack.polyus.goldenrush.services.interfaces.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    ScheduleRepo scheduleRepo;
    ErpAdapter erpAdapter;
    MessagingService messagingService;
    ScheduleGenerator scheduleGenerator;
    RequestService requestService;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepo scheduleRepo, ErpAdapter erpAdapter, MessagingService messagingService, ScheduleGenerator scheduleGenerator, RequestService requestService) {
        this.scheduleRepo = scheduleRepo;
        this.erpAdapter = erpAdapter;
        this.messagingService = messagingService;
        this.scheduleGenerator = scheduleGenerator;
        this.requestService = requestService;
    }

    @Override
    public Schedule getSchedule(Date date) {
        return scheduleRepo.getScheduleByDate(date);
    }

    @Override
    public void updateSchedule(Long id) {
        Schedule schedule = scheduleRepo.getScheduleById(id);
        scheduleRepo.save(schedule);
    }

    @Scheduled(
            cron = "0 0 08 00 * ?",
            fixedDelay = 43200000
    )
    public void generateSchedule(){
        LocalDateTime localDateTimeStart = LocalDateTime.now();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        time = time.plusHours(12);
        LocalDateTime localDateTimeFinish = LocalDateTime.of(date,time);


        List<Transport> transport = erpAdapter.getTransportForShift();
        List<Request> requests = requestService.getRequestsForPeriod(localDateTimeStart, localDateTimeFinish);
        Schedule schedule = scheduleGenerator.generate(transport, requests);
        scheduleRepo.save(schedule);
        for(TimeLine timeLine: schedule.getTimeLines()){
            messagingService.sendLocationNotification(timeLine.getTransport().getId(), timeLine.getTransport().getCoord());
        }
    }
}
