package kz.iitu.history.management.controller;

import kz.iitu.history.management.entity.History;
import kz.iitu.history.management.repositotory.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/history")
public class HistoryController {
    private final HistoryRepository historyRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;
//
//    @Autowired
//    private TripService tripService ;

    @Autowired
    public HistoryController(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }


    //Aggregate

    @GetMapping("/all")
    public List<History> getList(){
        return historyRepository.findAll();
    }

    @PostMapping("/create")
    public History create(@RequestBody History history){return  historyRepository.save(history);}

    //Single
    @GetMapping("/all/{passengerId}")
    public List<History> getList(@PathVariable Long passengerId){
        return historyRepository.findByPassengerId(passengerId);
    }
//
//    @GetMapping("/all/{id}")
//    public Optional<Location> one(@PathVariable Long id) {
//        return locationRepository.findById(id);
//
//    }
//    @DeleteMapping("/all/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        locationRepository.deleteById(id);
//    }
//    @CrossOrigin("http://localhost:8006")
////    @HystrixCommand(fallbackMethod = "getFallbackLocationsTrip")
//    @GetMapping("/locationsTrip/{tripId}")
//    public List<Location> findLocationsTrip(@PathVariable Long tripId){
//        System.out.println("im here");
//        Trip trip = tripService.getLocationsTrip(tripId);
//        return locationRepository.findByTripId(trip.getId());
//    }

}