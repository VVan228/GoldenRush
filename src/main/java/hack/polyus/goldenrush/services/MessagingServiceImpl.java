package hack.polyus.goldenrush.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import hack.polyus.goldenrush.models.messaging.Params;
import hack.polyus.goldenrush.models.messaging.PublishNotification;
import hack.polyus.goldenrush.models.transport.Coordinate;
import hack.polyus.goldenrush.models.transport.Request;
import hack.polyus.goldenrush.services.interfaces.MessagingService;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class MessagingServiceImpl implements MessagingService {

    @Value("${centrifugo.api_key}")
    String api;


    @Override
    public void sendLocationNotification(Long transportId, Coordinate coordinate) {
        Gson gson = new Gson();
        PublishNotification notification = new PublishNotification();
        notification.setMethod("publish");
        Params params = new Params();
        params.setChannel(String.format("%d_out",transportId));
        params.setData(coordinate);
        notification.setParams(params);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8000/api"))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(notification)))
                .header("Authorization", "apikey " + api)
                .build();

        try {
            client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void sendEmergencyRequestNotification(Long transportId, Request request) {

    }
}
