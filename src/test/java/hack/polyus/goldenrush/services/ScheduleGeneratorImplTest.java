package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.services.interfaces.ScheduleService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScheduleGeneratorImplTest {

    ScheduleService scheduleService;

    @Autowired
    ScheduleGeneratorImplTest(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @Test
    public void getBest() {

    }
}