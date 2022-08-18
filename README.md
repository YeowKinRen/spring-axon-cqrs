# spring-cqrs

Basic Demo project for CQRS and Event Sourcing with Spring Boot and Axon Framework


Notes
--------
### Terminologies

- **Event Sourcing** : A design pattern that captures state changes as an event. State changes are persisted as events in an Event Store.
	- Atomic Update 
	
	- Audit logging 
	
	- Recovery 
	
- **CQRS** (Command Query Responsibility Segregation): The responsibility to read and present a view of an aggregate (Query) is separated from updating the state of an aggregate (Command)

- Command - intent to change an object's state
- Query - intent to request for information of an object's state
- Event - object that describe something that has occurred in the application
- Event Bus - mechanism that dispatches events to the subscribe event handlers
- Event Store - an event bus that is able to persists published events and is able to retrieve previous events based on a given aggregate identifier (Event Bus + persistence)


### Axon Annotations

- ```@AggregateIdentifier```: 

- ``` @CommandHandler```: 

- ```@EventSourcingHandler```: 
  
- ```@TargetAggregateIdentifier```: 



Resource
--------

- [CQRS and Event Sourcing with Spring Boot and Axon Framework](https://www.youtube.com/watch?v=SL2VSYecDvQ)
- [A Guide to the Axon Framework](https://www.baeldung.com/axon-cqrs-event-sourcing)


