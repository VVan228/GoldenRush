package hack.polyus.goldenrush.models.transport;

import hack.polyus.goldenrush.models.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    User user;

    String number;
    String model;

    DriverStatus status;
    @ManyToOne
    TransportData transportData;
    @Embedded
    Coordinate coord;
}
