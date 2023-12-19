package dev.mark.apimovies.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "years")
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_year")
    private Long id;

    private Long creation_year;

    public Year() {
    }

    public Year(Long creation_year) {
        this.creation_year = creation_year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreation_year() {
        return creation_year;
    }

    public void setCreation_year(Long creation_year) {
        this.creation_year = creation_year;
    }
    
}
