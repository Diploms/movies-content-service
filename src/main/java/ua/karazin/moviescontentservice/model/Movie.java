package ua.karazin.moviescontentservice.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import ua.karazin.moviesbaseevents.movies.revision2.*;

import java.math.BigDecimal;

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

    @NotNull
    @Positive
    private BigDecimal price;

    @CommandHandler
    private Movie(CreateMovieCommand2 command) {
        apply(new MovieCreatedEvent2(command.movieId(), command.movie()));
    }

    @CommandHandler
    private void process(UpdateMovieCommand2 command) {
        apply(new MovieUpdatedEvent2(command.movieId(), command.movie()));
    }

    @CommandHandler
    private void process(DeleteMovieCommand2 command) {
        apply(new MovieDeletedEvent2(id));
    }

    @EventSourcingHandler
    private void handle(MovieCreatedEvent2 event) {
        this.id = event.movieId();
        this.title = event.movie().title();
        this.releaseYear = event.movie().releaseYear();
    }

    @EventSourcingHandler
    private void handle(MovieUpdatedEvent2 event) {
        this.id = event.movieId();
        this.title = event.movie().title();
        this.releaseYear = event.movie().releaseYear();
    }

    @EventSourcingHandler
    private void handle(MovieDeletedEvent2 event) {
        markDeleted();
    }
}
