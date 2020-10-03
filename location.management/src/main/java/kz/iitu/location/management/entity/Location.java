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
    private int id;
    @Column(name = "trip_id")
    private int tripId;
    @Column(name = "first_loc")
    private String firstLoc;
    @Column(name  = "last_loc")
    private String lastLoc;
    @Column(name = "seq")
    private int seq;

    public Location() {
    }

    public Location(int id, int tripId, String firstLoc, String lastLoc, int seq) {
        this.id = id;
        this.tripId = tripId;
        this.firstLoc = firstLoc;
        this.lastLoc = lastLoc;
        this.seq = seq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
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
