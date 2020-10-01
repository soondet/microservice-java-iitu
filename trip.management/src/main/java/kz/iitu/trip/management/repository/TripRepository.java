package kz.iitu.trip.management.repository;

import kz.iitu.trip.management.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}
