package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.transport.*;
import hack.polyus.goldenrush.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransportRepo extends JpaRepository<Transport, Long> {

    //@Modifying
    //@Query("update Transport t set t.coord =: coords where  t.number =:number")
    //void setCoords(@Param(value = "coords") Coordinate coords, @Param(value = "number") String number);

    @Query("select t.coord from  Transport t where t.number=:number")
    Coordinate getCoords(@Param(value = "number") String number);

    //@Query("update Transport t set t.user =:driver where t.number=:number")
    //void setDriver(@Param(value = "driver") User driver, @Param(value = "number") String number);


}
