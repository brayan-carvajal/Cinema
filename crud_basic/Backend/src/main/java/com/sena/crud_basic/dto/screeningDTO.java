package com.sena.crud_basic.dto;

import java.util.Date;
import com.sena.crud_basic.model.movie;
import com.sena.crud_basic.model.room;

public class screeningDTO {
    private movie movie; // Objeto completo en lugar del ID
    private room room; // Objeto completo en lugar del ID
    private Date dateTime; // Fecha y hora de la función

    // Constructor vacío
    public screeningDTO() {
    }

    // Constructor con parámetros
    public screeningDTO(movie movie, room room, Date dateTime) {
        this.movie = movie;
        this.room = room;
        this.dateTime = dateTime;
    }

    // Getters y Setters
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
