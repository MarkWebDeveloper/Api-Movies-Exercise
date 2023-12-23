package dev.mark.apimovies.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_movie")
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private Set<GenreMovie> genres_movies;

    private String title;
    private String description;
    private Long running_time;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "year_id", nullable = true)
    private Year creation_year;
    
    public Movie() {
    }

    public Movie(Set<GenreMovie> genres_movies, String title, String description, Long running_time,
            Year creation_year) {
        this.genres_movies = genres_movies;
        this.title = title;
        this.description = description;
        this.running_time = running_time;
        this.creation_year = creation_year;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<GenreMovie> getGenres_movies() {
        return genres_movies;
    }

    public void setGenres_movies(Set<GenreMovie> genres_movies) {
        this.genres_movies = genres_movies;
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

    public Long getRunning_time() {
        return running_time;
    }

    public void setRunning_time(Long running_time) {
        this.running_time = running_time;
    }

    public Year getCreation_year() {
        return creation_year;
    }

    public void setCreation_year(Year creation_year) {
        this.creation_year = creation_year;
    }

    

}
