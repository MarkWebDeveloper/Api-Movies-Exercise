package dev.mark.apimovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mark.apimovies.models.Movie;

public interface GenreRepository extends JpaRepository<Movie,Long> {
    
}
