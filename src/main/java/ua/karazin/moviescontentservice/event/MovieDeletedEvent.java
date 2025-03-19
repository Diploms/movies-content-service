package ua.karazin.moviescontentservice.event;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record MovieDeletedEvent(@TargetAggregateIdentifier String id) {
}
