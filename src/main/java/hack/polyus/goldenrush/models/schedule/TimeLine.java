package hack.polyus.goldenrush.models.schedule;

import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.models.transport.Transport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TimeLine {

    @Id
    Long id;
    @OneToOne
    Transport transport;
    @OneToMany(fetch = FetchType.LAZY)
    ArrayList<Request> shedule;
}
