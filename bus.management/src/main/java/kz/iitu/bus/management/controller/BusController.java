package kz.iitu.bus.management.controller;

import kz.iitu.bus.management.entity.Bus;
import kz.iitu.bus.management.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
