package kz.iitu.bus.management.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(schema = "public" ,name="drivers" )
public class Driver {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "bus_id")
    private int busId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "iin" )
    private int IIN;
    @Column(name = "experience")
    private double experience;
    @Column(name = "driving_license_level")
    private String drivingLicenseLevel;

    public Driver() {
    }

    public Driver(int id, int busId, String name, String surname, int IIN, double experience, String drivingLicenseLevel) {
        this.id = id;
        this.busId = busId;
        this.name = name;
        this.surname = surname;
        this.IIN = IIN;
        this.experience = experience;
        this.drivingLicenseLevel = drivingLicenseLevel;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIIN() {
        return IIN;
    }

    public void setIIN(int IIN) {
        this.IIN = IIN;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public String getDrivingLicenseLevel() {
        return drivingLicenseLevel;
    }

    public void setDrivingLicenseLevel(String drivingLicenseLevel) {
        this.drivingLicenseLevel = drivingLicenseLevel;
    }
}
