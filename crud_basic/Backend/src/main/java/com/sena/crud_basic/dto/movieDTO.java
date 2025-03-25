package com.sena.crud_basic.dto;

public class movieDTO {
    private String title;
    private String description;
    private int duration;
    private String imageUrl;

    public movieDTO(String title, String description, int duration, String imageUrl) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.imageUrl = imageUrl;
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
