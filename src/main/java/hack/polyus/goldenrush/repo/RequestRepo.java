package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.transport.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepo extends JpaRepository<Request, Long> {
    Request getRequestById(Long id);

    void deleteById(Long id);
}
