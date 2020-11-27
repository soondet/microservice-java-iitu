package kz.iitu.location.management.controller;


import kz.iitu.location.management.entity.LocationRequest;
import kz.iitu.location.management.service.impl.Producer;
import kz.iitu.location.management.service.impl.TripServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/location/request")
public class LocationRequestController {
    private final Producer producer;
    private TripServiceImpl tripService;

    @Autowired
    public LocationRequestController(Producer producer, TripServiceImpl tripService) {
        this.producer = producer;
        this.tripService = tripService;
    }

    // TODO Ideally there should POST request
    @GetMapping
    public String sendMessageToKafkaTopic2(@RequestParam("userId") String userId,
                                           @RequestParam("tripId") Long tripId) {

        LocationRequest locationRequest = new LocationRequest(userId, tripService.getLocationsTrip(tripId));
        this.producer.locationRequestNotify(locationRequest);
        return "Your request sent successful!";
    }
}
