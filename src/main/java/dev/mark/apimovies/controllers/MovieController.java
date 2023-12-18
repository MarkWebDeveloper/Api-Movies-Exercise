package dev.mark.apimovies.controllers;


import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.mark.apimovies.services.MovieService;

import dev.mark.apimovies.models.Movie;

@RestController
@RequestMapping(path = "${api-endpoint}/movies")
public class MovieController {

    MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Movie> index() {

        List<Movie> movies = service.getAll();
        return movies;

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Movie> show(@PathVariable("id") Long id) throws Exception {

        Movie movie = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(movie);
    }

}