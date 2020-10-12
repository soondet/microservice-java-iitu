package kz.iitu.ticket.management.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public" ,name="passenger" )
public class Passenger {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "iin" )
    private int IIN;
    @Column(name = "credit_card")
    private String creditCard;
    @Column(name = "money")
    private int money;

    public Passenger() {
    }

    public Passenger(int id, String name, String surname, int IIN, String creditCard, int money) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.IIN = IIN;
        this.creditCard = creditCard;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int Money) {
        this.money = money;
    }
}
