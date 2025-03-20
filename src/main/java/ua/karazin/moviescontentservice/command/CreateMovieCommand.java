package ua.karazin.moviescontentservice.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import ua.karazin.moviescontentservice.dto.MovieDto;

import java.util.UUID;

public record CreateMovieCommand(@TargetAggregateIdentifier UUID movieId,
                                 MovieDto movie) {
}
