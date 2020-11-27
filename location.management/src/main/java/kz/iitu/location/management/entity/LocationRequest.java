package kz.iitu.location.management.entity;

public class LocationRequest {

    private String userId;
    private Trip trip;

    public LocationRequest(String userId, Trip trip) {
        this.userId = userId;
        this.trip = trip;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return "LocationRequest{" +
                "userId='" + userId + '\'' +
                ", trip=" + trip +
                '}';
    }
}
