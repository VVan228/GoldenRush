package hack.polyus.goldenrush.controller;

import hack.polyus.goldenrush.models.schedule.Schedule;
import hack.polyus.goldenrush.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class ScheduleController {

    ScheduleService scheduleService;

    @Autowired
    ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    /*@ResponseBody
    @RequestMapping(
            value = "/schedules/get/{date}/",
            method = RequestMethod.POST
    )
    public Schedule getScheduleByDate(@PathVariable String date) {

        return scheduleService.getSchedule(date);
    }*/
}
