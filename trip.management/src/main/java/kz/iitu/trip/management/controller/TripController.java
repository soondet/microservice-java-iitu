package kz.iitu.trip.management.controller;

import kz.iitu.trip.management.entity.Trip;
import kz.iitu.trip.management.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
