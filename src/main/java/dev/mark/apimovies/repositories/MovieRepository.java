package dev.mark.apimovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.mark.apimovies.models.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {

}
