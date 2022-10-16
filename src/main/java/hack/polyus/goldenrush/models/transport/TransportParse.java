package hack.polyus.goldenrush.models.transport;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TransportParse {
    Long transport_data_id;
    double lat;
    double lon;
    String[] transport_data;
    Long client_id;
    LocalDate date;
    LocalDateTime start;
    LocalDateTime end;
}
