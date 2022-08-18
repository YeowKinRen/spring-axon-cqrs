package com.example.springcqrs.command.command;

import java.util.Objects;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author 
 * Commands describe an intent to change the application's state. 
 * They are implemented as (preferably read-only) POJOs that are wrapped using one of the 
 * CommandMessage implementations.
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseCommand<?> other = (BaseCommand<?>) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BaseCommand [id=" + id + "]";
	}

}