package ua.karazin.moviescontentservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.karazin.moviescontentservice.command.CreateMovieCommand;
import ua.karazin.moviescontentservice.command.DeleteMovieCommand;
import ua.karazin.moviescontentservice.command.UpdateMovieCommand;
import ua.karazin.moviescontentservice.dto.MovieDto;
import ua.karazin.moviescontentservice.model.Movie;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<Movie> create(@RequestBody @Valid MovieDto movie) {
        var createCommand = new CreateMovieCommand(UUID.randomUUID(), movie);
        return commandGateway.send(createCommand);
    }

    @PutMapping("/{id}")
    public CompletableFuture<Movie> updateById(@PathVariable @NotNull UUID id, @RequestBody @Valid MovieDto movie) {
        var updateCommand = new UpdateMovieCommand(id, movie);
        return commandGateway.send(updateCommand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @NotNull UUID id) {
        commandGateway.send(new DeleteMovieCommand(id));
        return ResponseEntity.noContent().build();
    }
}
