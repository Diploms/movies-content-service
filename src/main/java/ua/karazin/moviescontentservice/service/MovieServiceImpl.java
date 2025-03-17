package ua.karazin.moviescontentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ua.karazin.moviescontentservice.model.Movie;
import ua.karazin.moviescontentservice.repository.MovieRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(String id) {
        return movieRepository.findById(UUID.fromString(id)).orElseThrow();
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteById(String id) {
        var movie = movieRepository.findById(UUID.fromString(id)).orElseThrow();
        movieRepository.delete(movie);
    }
}
