package hack.polyus.goldenrush.services.interfaces;

import hack.polyus.goldenrush.models.transport.Request;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestService {

    List<Request> getAllRequests();

    void insert(Request request);

    void update(Long id);

    Request getRequestById(Long id);

    void deleteRequest(Long id);

    void confirmStart(Long id, LocalDateTime startTime);

    void confirmEnd(Long id, LocalDateTime endTime);

}
