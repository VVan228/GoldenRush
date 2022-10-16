package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.transport.*;
import hack.polyus.goldenrush.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransportRepo extends JpaRepository<Transport, Long> {

    //@Modifying
    //@Query("update Transport t set t.coord =: coords where  t.number =:number")
    //void setCoords(@Param(value = "coords") Coordinate coords, @Param(value = "number") String number);

    @Query("select t.coord from  Transport t where t.number=:number")
    Coordinate getCoords(@Param(value = "number") String number);


    @Modifying
    @Query("update Transport t set t.status=:status where t.id=:id")
    void setTransportStatus(@Param(value = "id") Long number, @Param(value = "status") DriverStatus status);

    @Query("select st.transport from Schedule s join s.timeLines st join st.shedule sts where s.date=?1 and s.nightShift=?2 and sts.clientId=?3")
    List<Transport> getClientTransport(LocalDate date, boolean nightShift, Long id);
    //@Query("update Transport t set t.user =:driver where t.number=:number")
    //void setDriver(@Param(value = "driver") User driver, @Param(value = "number") String number);


}
