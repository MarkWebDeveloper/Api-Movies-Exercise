package dev.mark.apimovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.mark.apimovies.models.Year;

public interface YearRepository extends JpaRepository<Year,Long> {

}
