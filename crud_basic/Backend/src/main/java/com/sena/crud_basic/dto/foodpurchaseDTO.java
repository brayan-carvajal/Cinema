package com.sena.crud_basic.dto;

import com.sena.crud_basic.model.customer;
import com.sena.crud_basic.model.food;

public class foodpurchaseDTO {
    private customer customer; // Objeto completo en lugar del ID
    private food food; // Objeto completo en lugar del ID
    private int quantity;

    // Constructor vacío
    public foodpurchaseDTO() {
    }

    // Constructor con parámetros
    public foodpurchaseDTO(customer customer, food food, int quantity) {
        this.customer = customer;
        this.food = food;
        this.quantity = quantity;
    }

    // Getters y Setters
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
