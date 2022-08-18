package com.example.springcqrs.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author 
 **/
public class BaseCommand<T> {

	// The TargetAggregateIdentifier annotation tells Axon that the annotated field is an id 
	// of a given aggregate to which the command should be targeted. 
    @TargetAggregateIdentifier
    private final T id;

    public BaseCommand(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

}