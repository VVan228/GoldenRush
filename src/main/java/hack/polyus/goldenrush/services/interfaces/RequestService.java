package hack.polyus.goldenrush.services.interfaces;

import hack.polyus.goldenrush.models.schedule.Request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RequestService {

    List<Request> getRequests(LocalDate date);
    List<Request> getRequestsClient(LocalDate date, Long id);

    void insert(Request request);

    void update(Long id);

    Request getRequestById(Long id);

    void deleteRequest(Long id);

    void confirmStart(Long id, LocalDateTime startTime);

    void confirmEnd(Long id, LocalDateTime endTime);

    List<Request> getRequestsForPeriod(LocalDateTime start, LocalDateTime finish);

}
