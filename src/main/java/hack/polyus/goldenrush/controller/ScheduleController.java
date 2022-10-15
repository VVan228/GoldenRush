package hack.polyus.goldenrush.controller;

import hack.polyus.goldenrush.services.interfaces.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
