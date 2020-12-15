package kz.iitu.schedule.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public" ,name="schedules" )
public class Schedule {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "bus_id")
    private int busId;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String  endTime;

    public Schedule() {
    }

    public Schedule(int id, int busId, String startTime, String endTime) {
        this.id = id;
        this.busId = busId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
