package dev.mark.apimovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mark.apimovies.models.Genre;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    
}
