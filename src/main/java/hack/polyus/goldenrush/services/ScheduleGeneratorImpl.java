package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.schedule.Schedule;
import hack.polyus.goldenrush.models.schedule.TimeLine;
import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.models.transport.Transport;
import hack.polyus.goldenrush.services.interfaces.ScheduleGenerator;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;


public class ScheduleGeneratorImpl implements ScheduleGenerator {
    @Value("${base.point.lon}")
    private double base_lon; //x1
    @Value("${base.point.lat}")
    private double base_lat; //y1

    Map<String, List<Request>> typesTransportReq;

    @Override
    public Schedule generate(List<Transport> transportList, List<Request> requests) {

        Schedule readySchedule = new Schedule();
        TimeLine timeLine;

        // сортируем по типу запросы
        typesTransportReq = new HashMap<>();
        for (Request r: requests) {
            String key = r.getTransportData().getTransportType().getName();
            if (typesTransportReq.containsKey(key)) {
                List<Request> help = typesTransportReq.get(key);
                help.add(r);
                typesTransportReq.put(key, help);
            } else {
                typesTransportReq.put(key, new LinkedList<>());
            }
        }

        // сортируем по типу транспорт
        Map<String, List<Transport>> nowTransport = new HashMap<>();
        for (Transport t: transportList) {
            String key = t.getTransportData().getTransportType().getName();
            if (nowTransport.containsKey(key)) {
                List<Transport> help = nowTransport.get(key);
                help.add(t);
                nowTransport.put(key, help);
            } else {
                typesTransportReq.put(key, new LinkedList<>());
            }
        }

        // id_авто + id_ее заказов
        Map<Long, List<Request>> ans = new HashMap<>();

        // тип техники
        for (var entry : nowTransport.entrySet()) {
            //System.out.println(entry.getKey() + "/" + entry.getValue());
            // транспорт с конкретным типом
            timeLine = new TimeLine();
            for (Transport t: entry.getValue()) {

                // подходящий заказ к авто
                if (typesTransportReq.get(entry.getKey()).isEmpty()) {
                    System.out.println("Нет техники типа = " + entry.getKey());
                    break;
                }

                Request find_req = searchRequest(typesTransportReq.get(entry.getKey()), t);
                // записываем id_requests конкретного авто
                List<Request> ids_request = new LinkedList<>();
                if (ans.containsKey(t.getId())) {
                    ids_request = ans.get(t.getId());
                }
                ids_request.add(find_req);
                ans.put(t.getId(), ids_request);

                // ищем запросы по оставшемуся времени
                Request needReq = addReq(find_req.getEnd(), entry.getKey());
                typesTransportReq.get(entry.getKey()).remove(find_req);

                while (needReq != null) {
                    ids_request.add(needReq);
                    ans.put(t.getId(), ids_request);
                    needReq = addReq(needReq.getEnd(), entry.getKey());
                    // удаляем запрос из списка запросов данного типа
                    typesTransportReq.get(entry.getKey()).remove(find_req);
                }

                timeLine.setTransport(t);
                timeLine.setShedule(ans.get(t.getId()));
            }
            readySchedule.addTimeLine(timeLine);
        }

        return readySchedule;
    }

    public Request searchRequest(List<Request> typesTransportReq, Transport t) {

        Request find_req = typesTransportReq.get(0);
        Long min_chara = t.getTransportData().getParam_values().get(0).getValue();

        for (Request r: typesTransportReq) {
            if (t.getTransportData().getParam_values().get(0).getValue() - r.getTransportData().getParam_values().get(0).getValue() < min_chara) {
                min_chara = t.getTransportData().getParam_values().get(0).getValue() - r.getTransportData().getParam_values().get(0).getValue();
                find_req = r;
            }
        }
        return find_req;
    }


    public long timeDistanceBetween(double x1, double y1, double x2, double y2) {

        // дистанция в метрах
        double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) / 1852;
        return (long) (distance/7.0);
    }

    // ищем запросы по оставшемуся времени
    private Request addReq(LocalDateTime end_work, String key) {

        double minState = 86401;
        Request needReq = null;
        double x1, y1;
        x1 = this.base_lon;
        y1 = this.base_lat;
        for (Request request: typesTransportReq.get(key)) {

            long ds = timeDistanceBetween(x1, y1, request.getLon(), request.getLat());
            x1 = request.getLon();
            y1 = request.getLat();
            LocalDateTime start_work = end_work.plusSeconds(ds);
            if (request.getStart().isAfter(start_work)) {
                long sec = ChronoUnit.SECONDS.between(request.getStart(), start_work);
                double curr = ds * sec;
                if (curr < minState) {
                    needReq = request;
                    minState = curr;
                }
            }
        }

        return needReq;
    }
}
