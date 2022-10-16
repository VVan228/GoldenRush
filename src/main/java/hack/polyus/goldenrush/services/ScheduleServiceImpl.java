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

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    public Schedule getSchedule(LocalDate date) {
        LocalTime time = LocalTime.now();
        boolean nightShift = time.isAfter(LocalTime.of(20,0));
        return scheduleRepo.getScheduleByDateAndNightShift(date, nightShift);
    }

    @Override
    public void updateSchedule(Long id) {
        Schedule schedule = scheduleRepo.getScheduleById(id);
        scheduleRepo.save(schedule);
    }

    @Override
    public List<Request> getRequestsDriver(LocalDate date, Long id) {
        List<TimeLine> timeLines = getSchedule(LocalDate.now()).getTimeLines();
        List<Request> res = new ArrayList<>();
        for(TimeLine t: timeLines){
            if(t.getTransport().getUser().getId().equals(id)){
                res = t.getShedule();
            }
        }
        return res;
    }

    /*@Scheduled(
            cron = "0 10 08 * * *",
            fixedDelay = 43200000
    )*/
    public void generateSchedule(){
        System.out.println("its time!!");
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();

        boolean nightShift = timeNow.isAfter(LocalTime.of(20,0));


        List<Transport> transport = erpAdapter.getTransportForShift();
        List<Request> requests = requestService.getRequests(dateNow);
        System.out.println(dateNow);
        System.out.println(Arrays.toString(requests.toArray()));
        Schedule schedule = scheduleGenerator.generate(transport, requests);
        schedule.setDate(dateNow);
        schedule.setNightShift(nightShift);
        scheduleRepo.save(schedule);
        for(TimeLine timeLine: schedule.getTimeLines()){
            messagingService.sendLocationChangedNotification(timeLine.getTransport().getId(), timeLine.getTransport().getCoord());
        }
    }
}
