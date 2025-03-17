package ua.karazin.moviescontentservice.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import ua.karazin.moviescontentservice.model.Movie;

import java.util.UUID;

public record CreateMovieCommand(@TargetAggregateIdentifier String movieId,
                                 Movie movie) {
}
