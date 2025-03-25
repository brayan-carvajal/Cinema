package com.sena.crud_basic.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity(name = "screening")
public class screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idScreening")
    private int idScreening;

    @ManyToOne
    @JoinColumn(name = "idMovie", nullable = false)
    private movie movie;

    @ManyToOne
    @JoinColumn(name = "idRoom", nullable = false)
    private room room;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE) // Solo almacena fecha (sin hora)
    private Date dateTime ;

    // Constructor vacío
    public screening() {
    }

    // Constructor con parámetros
    public screening(int idScreening, movie movie, room room, Date dateTime) {
        this.idScreening = idScreening;
        this.movie = movie;
        this.room = room;
        this.dateTime = dateTime;
    }

    // Getters y Setters
    public int getIdScreening() {
        return idScreening;
    }

    public void setIdScreening(int idScreening) {
        this.idScreening = idScreening;
    }

    public movie getMovie() {
        return movie;
    }

    public void setMovie(movie movie) {
        this.movie = movie;
    }

    public room getRoom() {
        return room;
    }

    public void setRoom(room room) {
        this.room = room;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
