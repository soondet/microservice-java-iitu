package kz.iitu.location.management.entity;

public class LocationRequest {

    private Long tripId;
    private Trip trip;

    public LocationRequest(Long tripId, Trip trip) {
        this.tripId = tripId;
        this.trip = trip;

    }

    public LocationRequest() {
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
