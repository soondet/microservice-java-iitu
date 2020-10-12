package kz.iitu.driver.management.service;

import kz.iitu.driver.management.entity.Bus;

public interface BusService {
    Bus getDriversBus(Long tripId);
}
