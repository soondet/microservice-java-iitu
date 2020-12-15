package kz.iitu.schedule.management.repository;

import kz.iitu.schedule.management.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByBusId(int busId);
}
