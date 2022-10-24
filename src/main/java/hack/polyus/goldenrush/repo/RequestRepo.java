package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.schedule.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RequestRepo extends JpaRepository<Request, Long> {
    Request getRequestById(Long id);

    void deleteById(Long id);

    @Query("select r from Request r where r.start>?1 and r.end<?2 order by r.start")
    List<Request> getScheduleForPeriod(LocalDateTime start, LocalDateTime end);

    @Query("select r from Request r where r.date>=:date and r.nightShift=:nightShift")
    List<Request> getRequestsByShift(@Param("date") LocalDate date, @Param("nightShift") boolean nightShift);

    @Query("select r from Request r where r.clientId=?3 and r.date=?1 and r.nightShift=?2")
    List<Request> getRequestsByShiftClient(LocalDate date, boolean nightShift, Long id);


}
