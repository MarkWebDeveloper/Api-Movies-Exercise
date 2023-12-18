package dev.mark.apimovies.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_movie")
    private Long id;

    private String title;
    private int creation_year;
    private String description;
    private Long running_time;
    private String genre;
    private String main_actor;

    public Movie() {
    }

    public Movie(String title, int creation_year, String description, Long running_time, String genre,
            String main_actor) {
        this.title = title;
        this.creation_year = creation_year;
        this.description = description;
        this.running_time = running_time;
        this.genre = genre;
        this.main_actor = main_actor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCreation_year() {
        return creation_year;
    }

    public void setCreation_year(int creation_year) {
        this.creation_year = creation_year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRunning_time() {
        return running_time;
    }

    public void setRunning_time(Long running_time) {
        this.running_time = running_time;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMain_actor() {
        return main_actor;
    }

    public void setMain_actor(String main_actor) {
        this.main_actor = main_actor;
    }

    
    
}
