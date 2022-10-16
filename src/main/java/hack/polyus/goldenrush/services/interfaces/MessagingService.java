package hack.polyus.goldenrush.services.interfaces;

import hack.polyus.goldenrush.models.transport.Coordinate;
import hack.polyus.goldenrush.models.transport.DriverStatus;
import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.models.transport.Transport;


public interface MessagingService {
    void sendLocationChangedNotification(Long transportId, Coordinate coordinate);
    void sendStatusChangedNotification(Long transportId, DriverStatus status);
    void sendScheduleChangedNotification(Long transportId);
}
