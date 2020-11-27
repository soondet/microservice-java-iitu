package kz.iitu.jd3.notifyservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private Long id;
    private Long tripId;
    private String firstLoc;
    private String lastLoc;
    private int seq;

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", tripId=" + tripId +
                ", firstLoc='" + firstLoc + '\'' +
                ", lastLoc='" + lastLoc + '\'' +
                ", seq=" + seq +
                '}';
    }
}
