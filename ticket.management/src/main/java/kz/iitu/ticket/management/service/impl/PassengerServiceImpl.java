package kz.iitu.ticket.management.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.ticket.management.entity.Passenger;
import kz.iitu.ticket.management.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackPassengerIin",
            threadPoolKey = "getPassengerIin",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maximumSize", value="120"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
            })
    public Passenger getPassengerIin(int iin) {
        Passenger passenger = restTemplate.getForObject("http://localhost:8003/passenger/getByIin/" + iin,Passenger.class);
        return passenger;
    }

    public Passenger getFallbackPassengerIin(int iin){
        return new Passenger();
    }
}
