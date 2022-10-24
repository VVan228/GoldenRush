package hack.polyus.goldenrush.models.schedule;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RequestParse {
    Long transport_data_id;
    double lat;
    double lon;
    String[] transport_data;
    Long client_id;
    LocalDate date;
    LocalDateTime start;
    LocalDateTime end;
}
