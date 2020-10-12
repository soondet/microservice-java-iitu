package kz.iitu.ticket.management.service.impl;

import kz.iitu.ticket.management.entity.Passenger;
import kz.iitu.ticket.management.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Passenger getPassengerIin(int iin) {
        System.out.println("asdasd");
        Passenger passenger = restTemplate.getForObject("http://localhost:8003/passenger/getByIin/" + iin,Passenger.class);

        return passenger;
    }
}
