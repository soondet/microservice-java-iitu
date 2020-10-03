package kz.iitu.location.management.controller;

import kz.iitu.location.management.entity.Location;
import kz.iitu.location.management.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationRepository locationRepository;

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
    public Optional<Location> one(@PathVariable int id) {
        return locationRepository.findById(id);

    }
    @DeleteMapping("/all/{id}")
    void deleteEmployee(@PathVariable int id) {
        locationRepository.deleteById(id);
    }

}
