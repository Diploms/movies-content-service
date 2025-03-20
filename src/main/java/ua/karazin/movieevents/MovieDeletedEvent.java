package ua.karazin.movieevents;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public record MovieDeletedEvent(@TargetAggregateIdentifier UUID id) {
}
