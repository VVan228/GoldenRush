package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.repo.RequestRepo;
import hack.polyus.goldenrush.services.interfaces.RequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    RequestRepo requestRepo;

    @Override
    public List<Request> getAllRequests() {
        return requestRepo.findAll();
    }

    @Override
    public void insert(Request request) {
        requestRepo.save(request);
    }

    @Override
    public void update(Long id) {
        //requestRepo.save();
    }

    @Override
    public Request getRequestById(Long id) {
        return requestRepo.getRequestById(id);
    }

    @Override
    public void deleteRequest(Long id) {
        requestRepo.deleteById(id);
    }

    @Override
    public void confirmStart(Long id, LocalDateTime startTime) {

    }

    @Override
    public void confirmEnd(Long id, LocalDateTime endTime) {

    }

    @Override
    public List<Request> getRequestsForPeriod(LocalDateTime start, LocalDateTime finish) {
        return requestRepo.getScheduleForPeriod(start, finish);
    }
}
