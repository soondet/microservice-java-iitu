package kz.iitu.location.management.controller;


import kz.iitu.location.management.entity.LocationRequest;
import kz.iitu.location.management.service.impl.Producer;
import kz.iitu.location.management.service.impl.TripServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/locationRequest")
public class LocationRequestController {
    private final Producer producer;
    private TripServiceImpl tripService;

    @Autowired
    public LocationRequestController(Producer producer, TripServiceImpl tripService) {
        this.producer = producer;
        this.tripService = tripService;
    }

    // TODO Ideally there should POST request
    @GetMapping("/qq/{tripId}")
    public String sendMessageToKafkaTopic2(@PathVariable("tripId") Long tripId) {
        System.out.println("asd");
        LocationRequest locationRequest = new LocationRequest(tripId, tripService.getLocationsTrip(tripId));
        System.out.println(locationRequest.getTrip() + " " + locationRequest.getTripId());
        this.producer.locationRequestNotify(locationRequest);
        return "Your request sent successful!";
    }
}
