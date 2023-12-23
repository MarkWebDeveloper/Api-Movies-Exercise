package dev.mark.apimovies.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_genre")
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
    private Set<GenreMovie> genres_movies;

    private String genre_name;

    public Genre() {
    }

    public Genre(Set<GenreMovie> genres_movies, String genre_name) {
        this.genres_movies = genres_movies;
        this.genre_name = genre_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public Set<GenreMovie> getGenres_movies() {
        return genres_movies;
    }

    public void setGenres_movies(Set<GenreMovie> genres_movies) {
        this.genres_movies = genres_movies;
    }

    
    
}
