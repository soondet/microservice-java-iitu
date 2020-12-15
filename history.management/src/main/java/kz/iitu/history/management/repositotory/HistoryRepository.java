package kz.iitu.history.management.repositotory;

import kz.iitu.history.management.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository  extends JpaRepository<History,Long> {
    List<History> findByPassengerId(Long passengerId);
}
