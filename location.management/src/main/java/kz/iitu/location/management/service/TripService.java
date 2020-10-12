package kz.iitu.location.management.service;

import kz.iitu.location.management.entity.Location;
import kz.iitu.location.management.entity.Trip;

import java.util.List;

public interface TripService {
    Trip getLocationsTrip(Long tripId);

}
