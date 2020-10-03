package kz.iitu.trip.management.controller;

import kz.iitu.trip.management.entity.Trip;
import kz.iitu.trip.management.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trip")
public class TripController {
    private final TripRepository tripRepository;

    @Autowired
    public TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @GetMapping("/all")
    public List<Trip> getList(){
        return tripRepository.findAll();
    }

    @PostMapping("/create")
    public Trip create(@RequestBody Trip trip){return  tripRepository.save(trip);}

    //Single
    @GetMapping("/all/{id}")
    public Optional<Trip> one(@PathVariable int id) {
        return tripRepository.findById(id);

    }
    @DeleteMapping("/all/{id}")
    void deleteTrip(@PathVariable int id) {
        tripRepository.deleteById(id);
    }
}
