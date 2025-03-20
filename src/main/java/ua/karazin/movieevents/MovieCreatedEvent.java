package ua.karazin.movieevents;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import ua.karazin.moviescontentservice.dto.MovieDto;

import java.util.UUID;

public record MovieCreatedEvent(@TargetAggregateIdentifier UUID movieId,
                                MovieDto movie) {
}
