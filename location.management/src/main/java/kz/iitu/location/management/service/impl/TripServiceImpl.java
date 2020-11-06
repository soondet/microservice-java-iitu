package kz.iitu.location.management.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.location.management.entity.Trip;
import kz.iitu.location.management.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getFallbackLocationsTrip",
            threadPoolKey = "getLocationsTrip",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maximumSize", value="120"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
            })
    public Trip getLocationsTrip( Long tripId) {
        Trip trip = restTemplate.getForObject("http://localhost:8005/trip/all/" + tripId,Trip.class);
        return trip;
    }

    public Trip getFallbackLocationsTrip(Long tripId){
        System.out.println("sdsds");
        return new Trip((long) 1, "There isnt any trip");
    }
}
