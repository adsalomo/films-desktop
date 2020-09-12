/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuevana.films.models.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author adrian
 */
public class Movie {

    private int id;
    private String name;
    private String description;
    private String image;
    private LocalDateTime createdAt;
    private LocalDate releaseDate;
    private String actors;
    private String gender;
    private int rating;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the releaseDate
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the actors
     */
    public String getActors() {
        return actors;
    }

    /**
     * @param actors the actors to set
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return id + ";" + name + ";" + description + ";" + gender + ";" + image + ";"
                + createdAt + ";" + releaseDate + ";" + actors + ";" + rating + "\r\n";
    }

}
