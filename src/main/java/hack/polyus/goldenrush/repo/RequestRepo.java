package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.schedule.Schedule;
import hack.polyus.goldenrush.models.transport.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestRepo extends JpaRepository<Request, Long> {
    Request getRequestById(Long id);

    void deleteById(Long id);

    @Query("select r from Request r where r.start>?1 and r.end<?2 order by r.start")
    List<Request> getScheduleForPeriod(LocalDateTime start, LocalDateTime end);

}
