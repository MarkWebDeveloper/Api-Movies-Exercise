package dev.mark.apimovies.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// @Entity nos sirve para marcar un modelo.
@Entity
// @Table nos crea una tabla.
@Table(name = "movies")
public class Movie {
// @Id marca que el siguiente dato es la clave primaria de tipo id. @GeneratedValue significa que se asigna automáticamente. @Column nos aclara que es una columna y nos permite llamarla de cualquier manera.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_movie")
    private Long id;

// @ManyToMany nos marca la relación de muchos a muchos.  
    @ManyToMany
// @JoinTable sirve para crear nueva tabla. En nuestro caso es una tabla intermedia para la relacion de muchos a muchos. La tabla tiene nombre genres-movies y dos columnas - movie-id y genre-id. JoinColumns y inverseJoinColumns nos marcan los dos lados de asociación de la tabla intermedia. 
    @JoinTable(
        name = "genres_movies",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

    private String title;
    private String description;
    private Long running_time;
// nullable = true significa que si no añadimos ningún valor, year-id va a ser igual a null
    @ManyToOne
    @JoinColumn(name = "year_id", nullable = true)
    private Year creation_year;
    
    public Movie() {
    }

    public Movie(String title, String description, Long running_time) {
        this.title = title;
        this.description = description;
        this.running_time = running_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
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
