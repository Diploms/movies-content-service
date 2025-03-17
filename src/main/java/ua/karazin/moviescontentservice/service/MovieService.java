package ua.karazin.moviescontentservice.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import ua.karazin.moviescontentservice.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> findAll();
    Optional<Movie> findById(@NotBlank String id);
    Movie save(@Valid Movie movie);
    void deleteById(@NotBlank String id);
}
