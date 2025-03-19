package ua.karazin.moviescontentservice.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import ua.karazin.moviescontentservice.command.CreateMovieCommand;
import ua.karazin.moviescontentservice.command.DeleteMovieCommand;
import ua.karazin.moviescontentservice.command.UpdateMovieCommand;
import ua.karazin.moviescontentservice.event.MovieCreatedEvent;
import ua.karazin.moviescontentservice.event.MovieDeletedEvent;
import ua.karazin.moviescontentservice.event.MovieUpdatedEvent;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import static org.axonframework.modelling.command.AggregateLifecycle.markDeleted;

@Data
@NoArgsConstructor
@Aggregate
public class Movie {
    @AggregateIdentifier
    private String id;

    @NotBlank
    @Size(min = 1, max = 500)
    private String title;

    @NotNull
    @Min(1800)
    private Integer releaseYear;

    @CommandHandler
    private Movie(CreateMovieCommand command) {
        apply(new MovieCreatedEvent(command.movieId(), command.movie()));
    }

    @CommandHandler
    private void process(UpdateMovieCommand command) {
        apply(new MovieUpdatedEvent(command.id(), command.movie()));
    }

    @CommandHandler
    private void process(DeleteMovieCommand command) {
        apply(new MovieDeletedEvent(id));
    }

    @EventSourcingHandler
    private void handle(MovieCreatedEvent event) {
        this.id = event.movieId();
        this.title = event.movie().getTitle();
        this.releaseYear = event.movie().getReleaseYear();
    }

    @EventSourcingHandler
    private void handle(MovieUpdatedEvent event) {
        this.id = event.id();
        this.title = event.movie().getTitle();
        this.releaseYear = event.movie().getReleaseYear();
    }

    @EventSourcingHandler
    private void handle(MovieDeletedEvent event) {
        markDeleted();
    }
}
