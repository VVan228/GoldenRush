package hack.polyus.goldenrush.models.transport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transport {

    @Id
    String number;
    String model;
    @ManyToOne
    TransportData transportData;
    @Embedded
    Coordinate coord;
}
