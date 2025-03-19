package ua.karazin.moviescontentservice.event;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import ua.karazin.moviescontentservice.model.Movie;

public record MovieUpdatedEvent(@TargetAggregateIdentifier String id,
                                Movie movie) {
}
