package kz.iitu.bus.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public" ,name="buses" )
public class Bus {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "trip_id")
    private int tripId;
    @Column(name = "stateNumber")
    private String  state_number;
    @Column(name = "model")
    private String model;
    @Column(name = "year" )
    private int year;
    @Column(name = "capacity")
    private double capacity;

    public Bus() {
    }

    public Bus(int id, int tripId, String state_number, String model, int year, double capacity) {
        this.id = id;
        this.tripId = tripId;
        this.state_number = state_number;
        this.model = model;
        this.year = year;
        this.capacity = capacity;
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

    public String getState_number() {
        return state_number;
    }

    public void setState_number(String state_number) {
        this.state_number = state_number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
