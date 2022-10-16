package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.transport.Transport;
import hack.polyus.goldenrush.models.transport.TransportData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportDataRepo extends JpaRepository<TransportData, Long> {
}
