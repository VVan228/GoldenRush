package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.schedule.Schedule;
import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.models.transport.Transport;
import hack.polyus.goldenrush.services.interfaces.ScheduleGenerator;

import java.util.List;

public class ScheduleGeneratorImpl implements ScheduleGenerator {
    @Override
    public Schedule generate(List<Transport> transportList, List<Request> requests) {
        return null;
    }
}
