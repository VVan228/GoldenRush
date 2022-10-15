package hack.polyus.goldenrush.models.transport;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TransportData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    TransportType transportType;
    //Map<Long/*TransportParam*/, Long/*TransportParamValue*/> values;

    //values
    @OneToMany
    List<TransportParam> params = new ArrayList<>();
    @OneToMany
    List<TransportParamValue> param_values = new ArrayList<>();
}
