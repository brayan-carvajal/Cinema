package com.sena.crud_basic.dto;

import com.sena.crud_basic.model.customer;
import com.sena.crud_basic.model.screening;

public class ticketDTO {
    private customer customer; // Objeto completo en lugar del ID
    private screening screening; // Objeto completo en lugar del ID
    private double price; // Precio del boleto

    // Constructor vacío
    public ticketDTO() {
    }

    // Constructor con parámetros
    public ticketDTO(customer customer, screening screening, double price) {
        this.customer = customer;
        this.screening = screening;
        this.price = price;
    }

    // Getters y Setters
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
