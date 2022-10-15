package hack.polyus.goldenrush.models.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date date;
    @OneToMany(fetch = FetchType.LAZY)
    List<TimeLine> timeLines  = new ArrayList<>();

    public void addTimeLine(TimeLine tL) {
        this.timeLines.add(tL);
    }
}
