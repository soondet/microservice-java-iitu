package kz.iitu.ticket.management.controller;

import kz.iitu.ticket.management.entity.Ticket;
import kz.iitu.ticket.management.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class TicketController {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/all")
    public List<Ticket> getList(){
        return ticketRepository.findAll();
    }

    @PostMapping("/create")
    public Ticket create(@RequestBody Ticket ticket){return  ticketRepository.save(ticket);}
}
