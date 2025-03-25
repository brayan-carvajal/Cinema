package com.sena.crud_basic.dto;

import java.util.Date;
import com.sena.crud_basic.model.employee;

public class employeeshiftDTO {
    private employee employee;
    private Date date;

    // Constructor vacío
    public employeeshiftDTO() {
    }

    // Constructor con parámetros
    public employeeshiftDTO(employee employee, Date date) {
        this.employee = employee;
        this.date = date;
    }

    // Getters y Setters
    public employee getEmployee() {
        return employee;
    }

    public void setEmployee(employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
