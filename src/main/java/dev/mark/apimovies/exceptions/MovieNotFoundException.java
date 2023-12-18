package dev.mark.apimovies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import dev.mark.apimovies.exceptions.movie.MovieException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Country not found")
public class MovieNotFoundException extends MovieException {

    public MovieNotFoundException(String message) {
        super(message);
    }

    public MovieNotFoundException(String message, Throwable cause) {
        super(message,cause);
    }
    
}