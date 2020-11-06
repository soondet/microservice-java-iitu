package kz.iitu.driver.management.controller;

import kz.iitu.driver.management.entity.Bus;
import kz.iitu.driver.management.entity.Driver;
import kz.iitu.driver.management.repository.DriverRepository;
import kz.iitu.driver.management.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverRepository driverRepository;
    @Autowired
    private BusService busService;

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping("/all")
    public List<Driver> getList(){
        return driverRepository.findAll();
    }

    @PostMapping("/create")
    public Driver create(@RequestBody Driver driver){return  driverRepository.save(driver);}

    //Single
    @GetMapping("/all/{id}")
    public Optional<Driver> one(@PathVariable int id) {
        return driverRepository.findById(id);

    }

    @DeleteMapping("/all/{id}")
    void deleteDriver(@PathVariable int id) {
        driverRepository.deleteById(id);
    }

    @GetMapping("/bus/{busId}")
    public List<Driver> getByBus(@PathVariable int busId){
        return driverRepository.findBybusId(busId);
    }

    @GetMapping("driversBus/{busId}")
    public List<Driver> findLocationsTrip(@PathVariable Long busId){
        System.out.println("im here");
        Bus bus = busService.getDriversBus(busId);
        return driverRepository.findBybusId(bus.getId());
    }

}
