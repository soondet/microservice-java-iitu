package kz.iitu.location.management.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.iitu.location.management.entity.Location;
import kz.iitu.location.management.entity.Trip;
import kz.iitu.location.management.repository.LocationRepository;
import kz.iitu.location.management.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationRepository locationRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    private TripService tripService ;

    @Autowired
    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }



    //Aggregate

    @GetMapping("/all")
    public List<Location> getList(){
        return locationRepository.findAll();
    }

    @PostMapping("/create")
    public Location create(@RequestBody Location location){return  locationRepository.save(location);}

    //Single

    @GetMapping("/all/{id}")
    public Optional<Location> one(@PathVariable Long id) {
        return locationRepository.findById(id); 

    }
    @DeleteMapping("/all/{id}")
    void deleteEmployee(@PathVariable Long id) {
        locationRepository.deleteById(id);
    }
    @CrossOrigin("http://localhost:8006")
//    @HystrixCommand(fallbackMethod = "getFallbackLocationsTrip")
    @GetMapping("/locationsTrip/{tripId}")
    public List<Location> findLocationsTrip(@PathVariable Long tripId){
        System.out.println("im here");
        Trip trip = tripService.getLocationsTrip(tripId);
        return locationRepository.findByTripId(trip.getId());
    }
    
}
