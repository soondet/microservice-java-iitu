package kz.iitu.location.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public" ,name="trips" )
public class Trip {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "location")
    private String loc;

    public Trip() {
    }

    public Trip(Long id, String loc) {
        this.id = id;
        this.loc = loc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
