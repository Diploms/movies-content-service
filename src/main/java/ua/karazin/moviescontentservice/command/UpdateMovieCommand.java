package ua.karazin.moviescontentservice.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import ua.karazin.moviescontentservice.dto.MovieDto;

import java.util.UUID;

public record UpdateMovieCommand(@TargetAggregateIdentifier UUID id,
                                 MovieDto movie) {
}
