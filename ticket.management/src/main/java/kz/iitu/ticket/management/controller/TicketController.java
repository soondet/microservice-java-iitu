package kz.iitu.ticket.management.controller;

import kz.iitu.ticket.management.entity.Passenger;
import kz.iitu.ticket.management.entity.Ticket;
import kz.iitu.ticket.management.entity.Trip;
import kz.iitu.ticket.management.repository.PassengerRepository;
import kz.iitu.ticket.management.repository.TicketRepository;
import kz.iitu.ticket.management.repository.TripRepository;
import kz.iitu.ticket.management.service.PassengerService;
import kz.iitu.ticket.management.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketRepository ticketRepository;

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private TripService tripService;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private PassengerService passengerService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/all")
    public List<Ticket> getList(){
        return ticketRepository.findAll();
    }

    @PostMapping("/create")
    public Ticket create(@RequestBody Ticket ticket){return  ticketRepository.save(ticket);}

    @GetMapping("/ticketsTrip/{tripId}")
    public List<Ticket> findTicketTrip(@PathVariable Long tripId){
        System.out.println("im here");
        Trip trip = tripService.getTicketsTrip(tripId);
        return ticketRepository.findByTripId(trip.getId());
    }



    @GetMapping("/decrese/{id}")
    public List<Trip> decrease(@PathVariable Long id){
        System.out.println("im here");
        for(int i = 0 ;i<getList().size();i++){
            if(id == getList().get(i).getId()){
               Trip trip = tripService.getTicketsTrip(getList().get(i).getTripId());
                System.out.println(trip.getId() + trip.getNumb() + trip.getLoc());
               trip.setNumb(trip.getNumb() - 1);
                System.out.println(trip);
               tripRepository.save(trip);
            }
        }
        return tripRepository.findAll();
    }
    @GetMapping("/passengerIin/{id}/{passenger_iin}")
    public void setPassengerIin(@PathVariable("id") Long id,@PathVariable("passenger_iin") int iin){
        System.out.println("asdasd");
        for(int i = 0 ;i<getList().size();i++){
            if(id == getList().get(i).getId()){
                Passenger passenger = passengerService.getPassengerIin(iin);
                System.out.println(passenger.getIIN());
                System.out.println(getList().get(i).getIin() + " " + getList().get(i).getId());
                System.out.println(passenger.getMoney() - getList().get(i).getCost());
                passenger.setMoney(passenger.getMoney() - getList().get(i).getCost());
                getList().get(i).setIin(passenger.getIIN());
                passengerRepository.save(passenger);
            }
        }
    }

}
