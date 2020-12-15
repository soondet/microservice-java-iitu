package kz.iitu.history.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "public", name = "history")
public class History {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "passenger_id")
    private Long passengerId;
    @Column(name = "ticket_id")
    private Long ticketId;
    @Column(name = "cost")
    private int cost;

    public History() {
    }

    public History(Long id, Long passengerId, Long ticketId, int cost) {
        this.id = id;
        this.passengerId = passengerId;
        this.ticketId = ticketId;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
