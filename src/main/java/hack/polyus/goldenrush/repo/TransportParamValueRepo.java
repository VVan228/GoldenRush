package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.transport.Transport;
import hack.polyus.goldenrush.models.transport.TransportParamValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportParamValueRepo extends JpaRepository<TransportParamValue, Long> {
}
