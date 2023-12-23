package dev.mark.apimovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mark.apimovies.models.GenreMovie;

public interface GenreMovieRepository extends JpaRepository<GenreMovie,Long>{
    
}
