package dev.mark.apimovies.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.mark.apimovies.exceptions.movie.MovieNotFoundException;
import dev.mark.apimovies.messages.Message;

import dev.mark.apimovies.models.Year;
import dev.mark.apimovies.repositories.YearRepository;

@Service
public class YearService implements IGenericService<Year> {
    YearRepository repository;

    public YearService(YearRepository repository) {
        this.repository = repository;
    }

    public List<Year> getAll() {
        List<Year> years = repository.findAll();
        return years;
    }

    public Year getById(Long id) throws Exception {
        Year year = repository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie not found"));

        return year;
    }

    public Year save(Year year) {
        
        Year newYear = repository.save(year);
        return newYear;
    }

    public Year update(Long id, Year year) throws Exception {
        
        Year updatingYear = repository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
        
        updatingYear.setCreation_year(year.getCreation_year());

        Year updatedMovie = repository.save(updatingYear);
        
        return updatedMovie;
    }

    public Message delete(Long id) throws Exception {
        
        Year year = repository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie not found"));

        Long yearValue = year.getCreation_year();

        repository.delete(year);

        Message message = new Message();

        message.setMessage(yearValue + " is deleted from the movies table");

        return message;
    }

}
