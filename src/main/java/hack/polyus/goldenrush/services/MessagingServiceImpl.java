package hack.polyus.goldenrush.services;

import com.google.gson.Gson;
import hack.polyus.goldenrush.models.messaging.Params;
import hack.polyus.goldenrush.models.messaging.PublishNotification;
import hack.polyus.goldenrush.models.transport.Coordinate;
import hack.polyus.goldenrush.models.transport.DriverStatus;
import hack.polyus.goldenrush.services.interfaces.MessagingService;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class MessagingServiceImpl implements MessagingService {

    @Value("${centrifugo.api_key}")
    String api;
    Gson gson = new Gson();

    private void sendNotification(Object data, Long transportId){

        PublishNotification notification = new PublishNotification();
        notification.setMethod("publish");
        Params params = new Params();
        params.setChannel(String.format("%d_out", transportId));
        params.setData(data);
        notification.setParams(params);


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8000/api"))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(notification)))
                .header("Authorization", "apikey " + api)
                .build();

        try {
            HttpResponse e = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            //System.out.println(e.statusCode());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void sendLocationChangedNotification(Long transportId, Coordinate coordinate) {
        //System.out.println("location changing " + transportId);
        Map<String, Object> data = new HashMap<>();
        data.put("type","location");
        data.put("id",transportId);
        data.put("content", coordinate);

        sendNotification(data, transportId);

    }

    @Override
    public void sendStatusChangedNotification(Long transportId, DriverStatus status) {

        Map<String, Object> data = new HashMap<>();
        data.put("type","status");
        data.put("id",transportId);
        data.put("content", status);

        sendNotification(data, transportId);
    }

    @Override
    public void sendScheduleChangedNotification(Long transportId) {

        Map<String, Object> data = new HashMap<>();
        data.put("type","schedule");
        data.put("id",transportId);

        sendNotification(data, transportId);
    }
}
