package hack.polyus.goldenrush.models.schedule;

import hack.polyus.goldenrush.models.transport.Transport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TimeLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    Transport transport;
    @OneToMany(fetch = FetchType.LAZY)
    List<Request> shedule = new ArrayList<>();;
}
