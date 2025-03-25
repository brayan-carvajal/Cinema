package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "employee")
public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmployee")
    private int idEmployee;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    // Constructor vacio
    public employee() {
    }

    // Constructor
    public employee(int idEmployee, String name, String position) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.position = position;
    }

    // Getters y Setters
    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
