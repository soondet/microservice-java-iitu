package kz.iitu.driver.management.repository;

import kz.iitu.driver.management.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DriverRepository extends JpaRepository<Driver, Integer> {
    List<Driver> findBybusId(int busId);
}
