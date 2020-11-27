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

    private String userId;
    private Trip trip;

    public String getUserId() {
        return userId;
    }

    public Trip getTrip() {
        return trip;
    }
}
