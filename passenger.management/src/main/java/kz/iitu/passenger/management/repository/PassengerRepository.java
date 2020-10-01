package kz.iitu.passenger.management.repository;

import kz.iitu.passenger.management.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
}
