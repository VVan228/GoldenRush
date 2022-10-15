package hack.polyus.goldenrush.models.transport;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@ToString
public class Coordinate {
    double lon;
    double lat;
}
