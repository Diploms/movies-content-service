package ua.karazin.moviescontentservice.service;

import ua.karazin.moviescontentservice.dto.MovieChangeDto;
import ua.karazin.moviescontentservice.dto.MovieGetDto;
import ua.karazin.moviescontentservice.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(String id);
    Movie createFrom(MovieChangeDto dto);
    Movie updateFrom(MovieChangeDto dto, String id);
    void deleteById(String id);
}
