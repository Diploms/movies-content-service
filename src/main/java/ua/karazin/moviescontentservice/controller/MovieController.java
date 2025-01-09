package ua.karazin.moviescontentservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.karazin.moviescontentservice.dto.MovieChangeDto;
import ua.karazin.moviescontentservice.dto.MovieGetDto;
import ua.karazin.moviescontentservice.mapper.MovieMapper;
import ua.karazin.moviescontentservice.service.movieservice.MovieServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieServiceImpl movieServiceImpl;

    @GetMapping
    public List<MovieGetDto> getAll() {
        return movieServiceImpl.findAll().stream()
                .map(MovieMapper::toGetDto).toList();
    }

    @GetMapping("/{id}")
    public MovieGetDto getById(@PathVariable @NotBlank String id) {
        var movie = movieServiceImpl.findById(id);
        return MovieMapper.toGetDto(movie);
    }

    @PostMapping
    public MovieGetDto create(@RequestBody @Valid MovieChangeDto dto) {
        var movie = movieServiceImpl.createFrom(dto);
        return MovieMapper.toGetDto(movie);
    }

    @PatchMapping("/{id}")
    public MovieGetDto updateById(@PathVariable @NotBlank String id, @RequestBody @Valid MovieChangeDto dto) {
        var updated = movieServiceImpl.updateFrom(dto, id);
        return MovieMapper.toGetDto(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @NotBlank String id) {
        movieServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
