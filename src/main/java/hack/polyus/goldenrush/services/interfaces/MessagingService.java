package hack.polyus.goldenrush.services.interfaces;

import hack.polyus.goldenrush.models.transport.Coordinate;
import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.models.transport.Transport;

public interface MessagingService {
    void sendLocationNotification(Long transportId, Coordinate coordinate);
    void sendEmergencyRequestNotification(Long transportId, Request request);
}
