package hack.polyus.goldenrush.models.transport;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TransportParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long typeId;
    String name;
    boolean isEnum;


}
