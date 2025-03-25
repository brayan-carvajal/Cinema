package com.sena.crud_basic.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity(name = "employeeshift")
public class employeeshift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idShift  ")
    private int idShift;

    @ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private employee employee;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    // Constructor vacío
    public employeeshift() {
    }

    // Constructor con parámetros
    public employeeshift(int idShift , employee employee, Date date) {
        this.idShift  = idShift;
        this.employee = employee;
        this.date = date;
    }

    // Getters y Setters
    public int getIdShift () {
        return idShift ;
    }

    public void setIdShift(int idShift) {
        this.idShift  = idShift;
    }

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
