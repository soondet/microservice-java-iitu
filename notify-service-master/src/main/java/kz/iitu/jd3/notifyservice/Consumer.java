package kz.iitu.jd3.notifyservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    @KafkaListener(topics = "location_requests", groupId = "group_id")
    public void consume(LocationRequest locationRequest) throws IOException {
        System.out.println(String.format("#### -> Notify user by email: -> %s",
                "User " + locationRequest.getTripId() + "trip "
                        + locationRequest.getTrip().toString()));
    }
}