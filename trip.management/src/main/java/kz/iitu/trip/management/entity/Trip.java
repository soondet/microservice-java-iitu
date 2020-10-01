package kz.iitu.trip.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public" ,name="drivers" )
public class Trip {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "from")
    private String from;
    @Column(name = "to" )
    private String to;
    @Column(name = "region")
    private String region;


}
