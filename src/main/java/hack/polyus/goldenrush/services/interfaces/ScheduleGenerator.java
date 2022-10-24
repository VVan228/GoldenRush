package hack.polyus.goldenrush.services.interfaces;

import hack.polyus.goldenrush.models.schedule.Schedule;
import hack.polyus.goldenrush.models.schedule.Request;
import hack.polyus.goldenrush.models.transport.Transport;

import java.util.List;

public interface ScheduleGenerator {
    Schedule generate(List<Transport> transportList, List<Request> requests);
}
