package dev.mark.apimovies.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
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

}