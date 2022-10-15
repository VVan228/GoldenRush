package hack.polyus.goldenrush.models.messaging;

import lombok.Data;

@Data
public class Params {
    String channel;
    Object data;
}
