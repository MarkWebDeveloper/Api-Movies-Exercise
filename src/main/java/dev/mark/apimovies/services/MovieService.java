package dev.mark.apimovies.services;

import java.util.List;
import dev.mark.apimovies.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import dev.mark.apimovies.exceptions.movie.MovieNotFoundException;
import dev.mark.apimovies.messages.Message;
import dev.mark.apimovies.models.Movie;



@Service
public class MovieService {
    
    MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getAll() {
        List<Movie> movies = repository.findAll();
        return movies;
    }

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

}
