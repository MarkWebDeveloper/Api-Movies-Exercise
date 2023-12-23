package dev.mark.apimovies.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.mark.apimovies.models.Movie;
// Optional<Movie> findByTitle(String title) es un método añadido por nosotros al repositorio para poder encontrar películas por su título usando el parámetro title que se encuentra en nuestro modelo de Movie.
public interface MovieRepository extends JpaRepository<Movie,Long> {
    Optional<Movie> findByTitle(String title);
}
