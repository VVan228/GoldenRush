package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.transport.Coordinate;
import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.services.interfaces.MessagingService;
import org.springframework.beans.factory.annotation.Value;

import java.net.http.HttpClient;

public class MessagingServiceImpl implements MessagingService {

    @Value("${centrifugo.api_key}")
    String api;





    @Override
    public void sendLocationNotification(Long transportId, Coordinate coordinate) {

    }

    @Override
    public void sendEmergencyRequestNotification(Long transportId, Request request) {

    }
}
