package hack.polyus.goldenrush.controller;

import hack.polyus.goldenrush.models.schedule.Schedule;
import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.services.interfaces.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ScheduleController {

    ScheduleService scheduleService;

    @Autowired
    ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @ResponseBody
    @RequestMapping(
            value = "/schedules/get/{transportId}/",
            method = RequestMethod.GET
    )
    public List<Request> getScheduleByDate(@PathVariable Long transportId) {
        return scheduleService.getRequestsDriver(LocalDate.now(), transportId);
    }

    @ResponseBody
    @RequestMapping(
            value = "/schedules/getCurrent/",
            method = RequestMethod.GET
    )
    public Schedule getCurrentSchedule() {
        return scheduleService.getSchedule(LocalDate.now());
    }

}
