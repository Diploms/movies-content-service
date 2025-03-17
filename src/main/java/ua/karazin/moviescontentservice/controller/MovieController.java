package ua.karazin.moviescontentservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.karazin.moviescontentservice.dto.MovieChangeDto;
import ua.karazin.moviescontentservice.dto.MovieGetDto;
import ua.karazin.moviescontentservice.mapper.MovieMapperImpl;
import ua.karazin.moviescontentservice.service.MovieServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieServiceImpl movieServiceImpl;
    private final MovieMapperImpl movieMapperImpl;

    @GetMapping
    public List<MovieGetDto> getAll() {
        return movieServiceImpl.findAll().stream()
                .map(movieMapperImpl::toGetDto).toList();
    }

    @GetMapping("/{id}")
    public MovieGetDto getById(@PathVariable @NotBlank String id) {
        var movie = movieServiceImpl.findById(id);
        return movieMapperImpl.toGetDto(movie);
    }

    @PostMapping
    public MovieGetDto create(@RequestBody @Valid MovieChangeDto dto) {
        var movie = movieMapperImpl.toMovie(dto);
        movie = movieServiceImpl.save(movie);
        return movieMapperImpl.toGetDto(movie);
    }

    @PutMapping("/{id}")
    public MovieGetDto updateById(@PathVariable @NotBlank String id, @RequestBody @Valid MovieChangeDto dto) {
        var movie = movieMapperImpl.toMovie(dto);
        movie = movieServiceImpl.save(movie);
        return movieMapperImpl.toGetDto(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @NotBlank String id) {
        movieServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
