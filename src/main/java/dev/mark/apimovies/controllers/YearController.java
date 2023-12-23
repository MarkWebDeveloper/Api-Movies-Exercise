package dev.mark.apimovies.controllers;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.mark.apimovies.messages.Message;
import dev.mark.apimovies.models.Year;
import dev.mark.apimovies.services.IGenericService;
import dev.mark.apimovies.services.YearService;

@RestController
@RequestMapping(path = "${api-endpoint}/years")
public class YearController {

    IGenericService<Year> service;

    public YearController(YearService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Year> index() {

        List<Year> movies = service.getAll();
        return movies;

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Year> show(@PathVariable("id") Long id) throws Exception {

        Year year = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(year);
    }

    @PostMapping(path = "")
    public ResponseEntity<Year> create(@RequestBody Year year) {

        Year newMovie = service.save(year);

        return ResponseEntity.status(201).body(newMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Year> update(@PathVariable("id") Long id, @RequestBody Year year) throws Exception {

        Year updatedMovie = service.update(id, year);

        return ResponseEntity.status(200).body(updatedMovie);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Message> remove(@PathVariable("id") Long id) throws Exception { 

        Message delete = service.delete(id);

        return ResponseEntity.status(200).body(delete);
    }

}
