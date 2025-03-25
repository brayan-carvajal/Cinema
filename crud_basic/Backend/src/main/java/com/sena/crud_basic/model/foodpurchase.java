package com.sena.crud_basic.model;

import jakarta.persistence.*;

@Entity(name = "foodpurchase")
public class foodpurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPurchase")
    private int idPurchase;

    @ManyToOne
    @JoinColumn(name = "idCustomer", nullable = false)
    private customer customer;

    @ManyToOne
    @JoinColumn(name = "idFood", nullable = false)
    private food food;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    // Constructor vacío
    public foodpurchase() {
    }

    // Constructor con parámetros
    public foodpurchase(int idPurchase, customer customer, food food, int quantity) {
        this.idPurchase = idPurchase;
        this.customer = customer;
        this.food = food;
        this.quantity = quantity;
    }

    // Getters y Setters
    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public customer getCustomer() {
        return customer;
    }

    public void setCustomer(customer customer) {
        this.customer = customer;
    }

    public food getFood() {
        return food;
    }

    public void setFood(food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
