package kz.iitu.ticket.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public" ,name="ticket" )
public class Ticket {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "trip_id")
    private int tripId;
    @Column(name = "cost")
    private int cost;
    @Column(name = "status" )
    private String status;
    @Column(name = "passenger_iin")
    private int iin;
    @Column(name = "qrcode")
    private String qrcode;


    public Ticket(int id, int tripId, int cost, String status, int iin, String qrcode) {
        this.id = id;
        this.tripId = tripId;
        this.cost = cost;
        this.status = status;
        this.iin = iin;
        this.qrcode = qrcode;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIin() {
        return iin;
    }

    public void setIin(int iin) {
        this.iin = iin;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}
