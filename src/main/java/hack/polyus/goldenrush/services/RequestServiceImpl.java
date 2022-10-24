package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.schedule.Request;
import hack.polyus.goldenrush.repo.RequestRepo;
import hack.polyus.goldenrush.services.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    RequestRepo requestRepo;

    @Autowired
    public RequestServiceImpl(RequestRepo requestRepo) {
        this.requestRepo = requestRepo;
    }

    private boolean getNightShift(){
        LocalTime time = LocalTime.now();
        boolean nightShift = time.isAfter(LocalTime.of(20,0));
        System.out.println(nightShift?"night shift":"not night shift");
        return nightShift;
    }

    @Override
    public List<Request> getRequests(LocalDate date) {
        return requestRepo.getRequestsByShift(date,getNightShift());
    }

    @Override
    public List<Request> getRequestsClient(LocalDate date, Long id) {
        return requestRepo.getRequestsByShiftClient(date, getNightShift(), id);
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
