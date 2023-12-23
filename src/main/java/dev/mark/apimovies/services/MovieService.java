package dev.mark.apimovies.services;

import java.util.List;

import dev.mark.apimovies.repositories.MovieRepository;

import org.springframework.stereotype.Service;

import dev.mark.apimovies.exceptions.movie.MovieNotFoundException;
import dev.mark.apimovies.messages.Message;
import dev.mark.apimovies.models.Movie;

// @Service nos sirve para marcar un servicio. El servicio contiene las funciones para manipular el repositorio. Estas funciones se definen aquí para luego ser usadas dentro de los controladores.
@Service
public class MovieService implements IGenericService<Movie> {
    
    MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }
// findAll() es un método que existe por defecto en JpaRepository. Otras funciones estándares que usamos aquí son getById, save, y delete.
    public List<Movie> getAll() {
        List<Movie> movies = repository.findAll();
        return movies;
    }
// MovieNotFoundException es una excepción creada por nosotros que se lanza en el caso de que la película con el id introducido no existe.
    public Movie getById(Long id) throws Exception {
        Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie not found"));

        return movie;
    }

    public Movie save(Movie movie) {
        
        Movie newMovie = repository.save(movie);
        return newMovie;
    }

    public Movie update(Long id, Movie movie) throws Exception {
        
        Movie updatingMovie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
        
        updatingMovie.setTitle(movie.getTitle());
        updatingMovie.setDescription(movie.getDescription());
        updatingMovie.setRunning_time(movie.getRunning_time());

        Movie updatedMovie = repository.save(updatingMovie);
        
        return updatedMovie;
    }

    public Message delete(Long id) throws Exception {
        
        Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie not found"));

        String movieName = movie.getTitle();

        repository.delete(movie);

        Message message = new Message();

        message.setMessage(movieName + " is deleted from the movies table");

        return message;
    }

    public Movie getByTitle(String title) throws Exception {
        Movie movie = repository.findByTitle(title).orElseThrow(() -> new MovieNotFoundException("Movie not found"));

        return movie;
    }

}
