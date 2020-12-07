package kz.iitu.location.management.service.impl;

import kz.iitu.location.management.entity.LocationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "location_requests";

    @Autowired
    private KafkaTemplate<String, LocationRequest> kafkaTemplate;

    public String locationRequestNotify(LocationRequest locationRequest) {
        System.out.println(locationRequest.getTrip() + " " + locationRequest.getTripId());
        System.out.println(String.format("#### -> Producing location request to notification service -> %s", locationRequest));
        this.kafkaTemplate.send(TOPIC, locationRequest);
        return "Successfully";
    }
}