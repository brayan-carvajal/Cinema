package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "food")
public class food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFood")
    private int idFood;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    // Constructor vacio
    public food() {
    }

    // Constructor
    public food(int idFood, String name, Double price) {
        this.idFood = idFood;
        this.name = name;
        this.price = price;
    }

    // Getters y Setters
    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
