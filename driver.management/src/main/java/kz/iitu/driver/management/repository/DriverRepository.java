package kz.iitu.driver.management.repository;

import kz.iitu.driver.management.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
