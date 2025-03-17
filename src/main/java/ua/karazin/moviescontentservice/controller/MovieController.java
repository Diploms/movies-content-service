package ua.karazin.moviescontentservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.karazin.moviescontentservice.command.CreateMovieCommand;
import ua.karazin.moviescontentservice.model.Movie;
import ua.karazin.moviescontentservice.service.MovieServiceImpl;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieServiceImpl movieServiceImpl;
    private final CommandGateway commandGateway;

    @GetMapping
    public List<Movie> getAll() {
        return movieServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable @NotBlank String id) {
        return movieServiceImpl.findById(id).orElseThrow();
    }

    @PostMapping
    public CompletableFuture<Movie> create(@RequestBody @Valid Movie movie) {
        var createCommand = new CreateMovieCommand(UUID.randomUUID().toString(), movie);
        return commandGateway.send(createCommand);
    }

    @PutMapping("/{id}")
    public Movie updateById(@PathVariable @NotBlank String id, @RequestBody @Valid Movie movie) {
        return movieServiceImpl.save(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @NotBlank String id) {
        movieServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
