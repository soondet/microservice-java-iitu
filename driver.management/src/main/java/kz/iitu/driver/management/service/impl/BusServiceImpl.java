package kz.iitu.driver.management.service.impl;

import kz.iitu.driver.management.entity.Bus;
import kz.iitu.driver.management.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Bus getDriversBus(Long busId) {
        Bus bus = restTemplate.getForObject("http://localhost:8001/bus/all/" + busId,Bus.class);

        return bus ;
    }
}
