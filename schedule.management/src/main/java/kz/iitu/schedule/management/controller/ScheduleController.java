package kz.iitu.schedule.management.controller;

import kz.iitu.schedule.management.entity.Bus;
import kz.iitu.schedule.management.entity.Schedule;
import kz.iitu.schedule.management.repository.ScheduleRepository;
import kz.iitu.schedule.management.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleRepository scheduleRepository;
    @Autowired
    private BusService busService;

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/all")
    public List<Schedule> getList(){
        return scheduleRepository.findAll();
    }

    @PostMapping("/create")
    public Schedule create(@RequestBody Schedule schedule){return  scheduleRepository.save(schedule);}

    @GetMapping("/schedulesBus/{busId}")
    public List<Schedule> findSchedulesBus(@PathVariable int busId){
        System.out.println("im here");
        Bus bus = busService.getShedulesBus(busId);
        return scheduleRepository.findByBusId(bus.getId());
    }


}
