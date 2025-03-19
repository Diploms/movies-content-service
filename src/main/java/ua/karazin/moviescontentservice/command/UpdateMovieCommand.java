package ua.karazin.moviescontentservice.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import ua.karazin.moviescontentservice.model.Movie;

public record UpdateMovieCommand(@TargetAggregateIdentifier String id,
                                 Movie movie) {
}
