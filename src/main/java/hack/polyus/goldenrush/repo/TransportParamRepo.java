package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.transport.Transport;
import hack.polyus.goldenrush.models.transport.TransportParam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportParamRepo extends JpaRepository<TransportParam, Long> {
}
