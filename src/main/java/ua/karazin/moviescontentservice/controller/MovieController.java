package ua.karazin.moviescontentservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.karazin.moviesbaseevents.movies.revision2.CreateMovieCommand2;
import ua.karazin.moviesbaseevents.movies.revision2.DeleteMovieCommand2;
import ua.karazin.moviesbaseevents.movies.revision2.MovieDto2;
import ua.karazin.moviesbaseevents.movies.revision2.UpdateMovieCommand2;
import ua.karazin.moviescontentservice.model.Movie;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<Movie> create(@RequestBody @Valid MovieDto2 movie) {
        var createCommand = new CreateMovieCommand2(UUID.randomUUID().toString(), movie);
        return commandGateway.send(createCommand);
    }

    @PutMapping("/{id}")
    public CompletableFuture<Movie> updateById(@PathVariable @NotNull String id, @RequestBody @Valid MovieDto2 movie) {
        var updateCommand = new UpdateMovieCommand2(id, movie);
        return commandGateway.send(updateCommand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @NotNull String id) {
        commandGateway.send(new DeleteMovieCommand2(id));
        return ResponseEntity.noContent().build();
    }
}
