package ua.karazin.moviescontentservice.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record DeleteMovieCommand(@TargetAggregateIdentifier String id) {
}
