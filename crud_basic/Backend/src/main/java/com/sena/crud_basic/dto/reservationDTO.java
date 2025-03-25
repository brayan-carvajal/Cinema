package com.sena.crud_basic.dto;

import com.sena.crud_basic.model.customer;
import com.sena.crud_basic.model.screening;

public class reservationDTO {
    private customer customer; // Objeto completo en lugar del ID
    private screening screening; // Objeto completo en lugar del ID
    private int ticketQuantity;

    // Constructor vacío
    public reservationDTO() {
    }

    // Constructor con parámetros
    public reservationDTO(customer customer, screening screening, int ticketQuantity) {
        this.customer = customer;
        this.screening = screening;
        this.ticketQuantity = ticketQuantity;
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

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }
}
