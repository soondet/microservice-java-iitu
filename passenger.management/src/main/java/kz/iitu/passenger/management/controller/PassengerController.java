package kz.iitu.passenger.management.controller;

import kz.iitu.passenger.management.entity.Passenger;
import kz.iitu.passenger.management.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @GetMapping("/all")
    public List<Passenger> getList(){
        return passengerRepository.findAll();
    }

    @PostMapping("/create")
    public Passenger create(@RequestBody Passenger passenger){return  passengerRepository.save(passenger);}
}
