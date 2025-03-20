package ua.karazin.moviescontentservice.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public record DeleteMovieCommand(@TargetAggregateIdentifier UUID id) {
}
