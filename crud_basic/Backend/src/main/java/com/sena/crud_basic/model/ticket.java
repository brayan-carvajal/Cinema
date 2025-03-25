package com.sena.crud_basic.model;
import jakarta.persistence.*;

@Entity(name = "ticket")
public class ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTicket")
    private int idTicket;

    @ManyToOne
    @JoinColumn(name = "idCustomer", nullable = false)
    private customer customer;

    @ManyToOne
    @JoinColumn(name = "idScreening", nullable = false)
    private screening screening;

    @Column(name = "price", nullable = false)
    private double price;

    // Constructor vacío
    public ticket() {
    }

    // Constructor con parámetros
    public ticket(int idTicket, customer customer, screening screening, double price) {
        this.idTicket = idTicket;
        this.customer = customer;
        this.screening = screening;
        this.price = price;
    }

    // Getters y Setters
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public customer getCustomer() {
        return customer;
    }

    public void setCustomer(customer customer) {
        this.customer = customer;
    }

    public screening getScreening() {
        return screening;
    }

    public void setScreening(screening screening) {
        this.screening = screening;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
