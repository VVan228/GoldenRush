package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.destination_point.DestinationPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DestinationPointRepo extends JpaRepository<DestinationPoint, Long> {

//    @Query("select p from DestinationPoint p")
//    List<DestinationPoint> getAllDestinationPoints();

}
