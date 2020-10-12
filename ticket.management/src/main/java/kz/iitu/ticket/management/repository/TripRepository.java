package kz.iitu.ticket.management.repository;

import kz.iitu.ticket.management.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
