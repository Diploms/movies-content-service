package ua.karazin.movieevents;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import ua.karazin.moviescontentservice.dto.MovieDto;

import java.util.UUID;

public record MovieUpdatedEvent(@TargetAggregateIdentifier UUID id,
                                MovieDto movie) {
}
