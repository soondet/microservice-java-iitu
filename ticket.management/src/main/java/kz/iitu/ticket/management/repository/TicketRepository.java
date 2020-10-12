package kz.iitu.ticket.management.repository;

import kz.iitu.ticket.management.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    List<Ticket> findByTripId(Long tripId);
}
