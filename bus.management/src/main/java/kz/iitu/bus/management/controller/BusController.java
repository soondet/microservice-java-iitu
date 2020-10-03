package kz.iitu.bus.management.controller;

import kz.iitu.bus.management.entity.Bus;
import kz.iitu.bus.management.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Driver;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bus")
public class BusController {

    private final BusRepository busRepository;

    @Autowired
    public BusController(BusRepository busRepository){
        this.busRepository = busRepository;
    }

    @GetMapping("/all")
    public List<Bus> getList(){
        return busRepository.findAll();
    }

    @PostMapping("/create")
    public Bus create(@RequestBody Bus bus){return  busRepository.save(bus);}

    //Single

    @GetMapping("/all/{id}")
    public Optional<Bus> one(@PathVariable int id) {
        return busRepository.findById(id);
    }

    @DeleteMapping("/allDel/{id}")
    void deleteById(@PathVariable int id) {
        busRepository.deleteById(id);
    }

//    @GetMapping("/asd")
//    public List<Driver> getDrivers(){
//        RestTemplate restTemplate = new RestTemplate();
//
//        ResponseEntity<List<Driver>> driverResponse = restTemplate.exchange
//                ("http://localhost:8002/driver/bus/1", HttpMethod.GET, null, new ParameterizedTypeReference<List<Driver>>() {
//                });
//        List<Driver> drivers = driverResponse.getBody();
//        return drivers;
//    }

}
