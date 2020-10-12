package kz.iitu.ticket.management.service.impl;

import kz.iitu.ticket.management.entity.Trip;
import kz.iitu.ticket.management.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Trip getTicketsTrip(Long tripId) {
        System.out.println("asdasd");
        Trip trip = restTemplate.getForObject("http://localhost:8005/trip/all/" + tripId,Trip.class);
        System.out.println(trip);

        return trip;
    }
}
