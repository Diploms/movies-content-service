package ua.karazin.moviescontentservice.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import ua.karazin.moviescontentservice.dto.MovieChangeDto;
import ua.karazin.moviescontentservice.dto.MovieGetDto;
import ua.karazin.moviescontentservice.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(@NotBlank String id);
    Movie save(@Valid Movie dto);
    void deleteById(@NotBlank String id);
}
