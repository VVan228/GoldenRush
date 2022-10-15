package hack.polyus.goldenrush.models.transport;

import hack.polyus.goldenrush.models.user.User;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
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
