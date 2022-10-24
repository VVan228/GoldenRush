package hack.polyus.goldenrush.models.schedule;

import com.fasterxml.jackson.annotation.JsonFormat;
import hack.polyus.goldenrush.models.transport.TransportData;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long clientId;
    // dateTime
    // SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    LocalDateTime start;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    LocalDateTime end;

    //@JsonFormat(shape = JsonFormat.Shape.NUMBER)
    LocalDate date;
    boolean nightShift;

    @ManyToOne
    TransportData transportData;

    double lat;
    double lon;
}
