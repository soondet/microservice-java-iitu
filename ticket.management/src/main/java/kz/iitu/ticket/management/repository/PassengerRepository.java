package kz.iitu.ticket.management.repository;

import kz.iitu.ticket.management.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
}
