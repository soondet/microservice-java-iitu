package kz.iitu.jd3.notifyservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequest {

    private Long tripId;
    private Trip trip;


    public Long getTripId() {
        return tripId;
    }

    public Trip getTrip() {
        return trip;
    }
}
