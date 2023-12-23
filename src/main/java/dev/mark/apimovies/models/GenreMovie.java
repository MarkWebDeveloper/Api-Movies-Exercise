package dev.mark.apimovies.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "genres_movies")
public class GenreMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_genre_movie")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = true)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = true)
    private Genre genre;

    public GenreMovie() {
    }

    public GenreMovie(Movie movie, Genre genre) {
        this.movie = movie;
        this.genre = genre;
    }

}
