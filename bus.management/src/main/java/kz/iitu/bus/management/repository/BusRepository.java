package kz.iitu.bus.management.repository;

import kz.iitu.bus.management.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Integer> {
}
