package hack.polyus.goldenrush.models.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    Long id;
    Date date;
    @OneToMany(fetch = FetchType.LAZY)
    ArrayList<TimeLine> timeLines;
}
