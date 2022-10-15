package hack.polyus.goldenrush.models.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class TransportParamElement{
    String name;
    Long id;
    List<TransportParamValueEnum> values;

}
