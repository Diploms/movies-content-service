package ua.karazin.moviescontentservice.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ua.karazin.moviescontentservice.model.Movie;

import java.util.UUID;

@Repository
public interface MovieRepository extends ListCrudRepository<Movie, UUID> {
}
