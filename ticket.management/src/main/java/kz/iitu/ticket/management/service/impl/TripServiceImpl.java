package kz.iitu.ticket.management.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.ticket.management.entity.Trip;
import kz.iitu.ticket.management.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackTicketsTrip",
            threadPoolKey = "getTicketsTrip",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maximumSize", value="120"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
            })
    public Trip getTicketsTrip(Long tripId) {
        Trip trip = restTemplate.getForObject("http://localhost:8005/trip/all/" + tripId,Trip.class);
        return trip;
    }

    public Trip getFallbackTicketsTrip(Long tripId){
        return new Trip();
    }

}
