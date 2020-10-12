package kz.iitu.location.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(schema = "public", name = "locations")
public class Location {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "trip_id")
    private Long tripId;
    @Column(name = "first_loc")
    private String firstLoc;
    @Column(name  = "last_loc")
    private String lastLoc;
    @Column(name = "seq")
    private int seq;

    public Location() {
    }

    public Location(Long id, Long tripId, String firstLoc, String lastLoc, int seq) {
        this.id = id;
        this.tripId = tripId;
        this.firstLoc = firstLoc;
        this.lastLoc = lastLoc;
        this.seq = seq;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public String getFirstLoc() {
        return firstLoc;
    }

    public void setFirstLoc(String firstLoc) {
        this.firstLoc = firstLoc;
    }

    public String getLastLoc() {
        return lastLoc;
    }

    public void setLastLoc(String lastLoc) {
        this.lastLoc = lastLoc;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
