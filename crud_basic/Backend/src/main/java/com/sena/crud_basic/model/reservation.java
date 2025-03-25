package com.sena.crud_basic.model;

import jakarta.persistence.*;

@Entity(name = "reservation")
public class reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private int idReservation;

    @ManyToOne
    @JoinColumn(name = "idCustomer", nullable = false)
    private customer customer;

    @ManyToOne
    @JoinColumn(name = "idScreening", nullable = false)
    private screening screening;

    @Column(name = "ticketQuantity", nullable = false)
    private int ticketQuantity;

    // Constructor vacío
    public reservation() {
    }

    // Constructor
    public reservation(int idReservation, customer customer, screening screening, int ticketQuantity) {
        this.idReservation = idReservation;
        this.customer = customer;
        this.screening = screening;
        this.ticketQuantity = ticketQuantity;
    }

    // Getters y Setters
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
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

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }
}
