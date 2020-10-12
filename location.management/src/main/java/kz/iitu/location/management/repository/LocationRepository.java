package kz.iitu.location.management.repository;

import kz.iitu.location.management.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Long> {
    List<Location> findByTripId(Long tripId);
}
