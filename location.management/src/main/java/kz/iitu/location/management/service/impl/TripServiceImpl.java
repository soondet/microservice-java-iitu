package kz.iitu.location.management.service.impl;

import kz.iitu.location.management.entity.Trip;
import kz.iitu.location.management.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Trip getLocationsTrip( Long tripId) {
        System.out.println("asdasd");
        Trip trip = restTemplate.getForObject("http://localhost:8005/trip/all/" + tripId,Trip.class);
        System.out.println(trip);

        return trip;
    }
}
