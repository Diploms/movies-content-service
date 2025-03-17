package ua.karazin.moviescontentservice.event;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import ua.karazin.moviescontentservice.model.Movie;

public record MovieCreatedEvent(@TargetAggregateIdentifier String movieId,
                                Movie movie) {
}
