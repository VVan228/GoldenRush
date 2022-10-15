package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.schedule.Schedule;
import hack.polyus.goldenrush.models.schedule.TimeLine;
import hack.polyus.goldenrush.models.transport.*;
import hack.polyus.goldenrush.models.user.User;
import hack.polyus.goldenrush.services.interfaces.ScheduleService;
import hack.polyus.goldenrush.services.interfaces.TransportDataService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ScheduleGeneratorImplTest {

    ScheduleService scheduleService;
    TransportDataService transportDataService;

    @Autowired
    public ScheduleGeneratorImplTest(ScheduleService scheduleService, TransportDataService transportDataService) {
        this.scheduleService = scheduleService;
        this.transportDataService = transportDataService;
    }

    @Test
    public void getBestTime() {
        /*User user = new User();
        TransportType transportType = new TransportType(1L, "Парк кранов");
        TransportParam transportParam = new TransportParam(1L, 1L, "Грузоподъёмность", true);
        TransportParamValue transportParamValue = new TransportParamValue(1L, new TransportParamValueEnum())
        TransportData transportData = new TransportData(1L, transportType, new ArrayList<>().add(transportParam), )
        Transport transport = new Transport(
                1, user, "А306АА/999", "LIEBHERR LTM 1100-4.1",

        );
        TimeLine timeLine = new TimeLine()
        Schedule schedule = new Schedule()*/
        System.out.println(transportDataService.getTypes().size());

    }
}