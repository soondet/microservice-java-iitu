package kz.iitu.driver.management.controller;

import kz.iitu.driver.management.entity.Driver;
import kz.iitu.driver.management.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverRepository driverRepository;

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

}
