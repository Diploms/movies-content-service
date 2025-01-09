package ua.karazin.moviescontentservice.service.movieservice;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import ua.karazin.moviescontentservice.dto.MovieChangeDto;
import ua.karazin.moviescontentservice.dto.MovieGetDto;
import ua.karazin.moviescontentservice.mapper.MovieMapper;
import ua.karazin.moviescontentservice.model.Movie;
import ua.karazin.moviescontentservice.repository.MovieRepository;
import ua.karazin.moviescontentservice.service.MovieService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(@NotBlank String id) {
        return movieRepository.findById(UUID.fromString(id)).orElseThrow();
    }

    @Override
    public Movie createFrom(@NonNull MovieChangeDto dto) {
        var movie = MovieMapper.toMovie(dto);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateFrom(@NonNull MovieChangeDto dto, @NotBlank String id) {
        var original = movieRepository.findById(UUID.fromString(id)).orElseThrow();
        var updated = MovieMapper.toMovie(original, dto);

        return movieRepository.save(updated);
    }

    @Override
    public void deleteById(@NotBlank String id) {
        var movie = movieRepository.findById(UUID.fromString(id)).orElseThrow();
        movieRepository.delete(movie);
    }
}
