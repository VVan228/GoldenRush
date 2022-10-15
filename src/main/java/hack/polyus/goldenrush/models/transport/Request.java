package hack.polyus.goldenrush.models.transport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long clientId;
    // dateTime
    // SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
    Date start;
    Date end;
    @ManyToOne
    TransportData transportData;
}
