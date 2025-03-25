package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "movie")
public class movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovie")
    private int idMovie;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "imageUrl", length = 255, nullable = false)
    private String imageUrl;

    // Constructor vacio
    public movie() {
    }

    // Constructor
    public movie(int idMovie, String title, String description, int duration, String imageUrl) {
        this.idMovie = idMovie;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.imageUrl = imageUrl;
    }

    // Getters y Setters
    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
