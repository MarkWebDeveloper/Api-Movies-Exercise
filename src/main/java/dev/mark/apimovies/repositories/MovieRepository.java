package dev.mark.apimovies.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.mark.apimovies.models.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    Optional<Movie> findByTitle(String title);
}
