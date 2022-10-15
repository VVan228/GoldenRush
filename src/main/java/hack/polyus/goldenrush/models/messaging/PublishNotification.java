package hack.polyus.goldenrush.models.messaging;

import lombok.Data;

@Data
public class PublishNotification {
    String method;
    Params params;
}
