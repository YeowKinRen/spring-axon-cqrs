# spring-cqrs

Basic Demo project for CQRS and Event Sourcing with Spring Boot and Axon Framework

Axon Framework Architectural pattern
--------
![https://miro.medium.com/max/1400/0*woBH1evKypFlwBy2.jpg](https://miro.medium.com/max/1400/0*woBH1evKypFlwBy2.jpg)

![https://miro.medium.com/max/1400/0*FisWJdyLwv1o3_kv.gif](https://miro.medium.com/max/1400/0*FisWJdyLwv1o3_kv.gif)
![https://miro.medium.com/max/1400/0*clMT-J6la5mqr_Rg.gif](https://miro.medium.com/max/1400/0*clMT-J6la5mqr_Rg.gif)
![https://miro.medium.com/max/1400/0*GZybOTQ_FVbixzDe.gif](https://miro.medium.com/max/1400/0*GZybOTQ_FVbixzDe.gif)

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

#### Component 
- Command Bus: provides the mechanism of having commands routed to their respective Command Handlers. ```@CommandHandler``` annotation on Aggregate Class means that when the Command is created, your Aggregate Class's method would be called. The Command Bus is the component that makes this possible.

- Command Gateway - exposes a more friendly API to the Command Bus.

- Event Bus - mechanism that dispatches events to the subscribe event handlers. ```AggregateLifecycle.apply(new Event(command.getId, command.getStatus));```

- Event Store - an event bus that is able to persists published events and is able to retrieve previous events based on a given aggregate identifier (Event Bus + persistence)


### Axon Annotations

- ```@AggregateIdentifier```: 

- ``` @CommandHandler```: 

- ```@EventSourcingHandler```: 
  
- ```@TargetAggregateIdentifier```: 

- [```@EventHandler```](https://docs.axoniq.io/reference-guide/v/3.1/part-ii-domain-logic/event-handling): 

Resource
--------

- [Official AxonIQ Reference Guide](https://docs.axoniq.io/reference-guide/axon-framework/introduction)
- [CQRS and Event Sourcing with Spring Boot and Axon Framework](https://www.youtube.com/watch?v=SL2VSYecDvQ)
- [A Guide to the Axon Framework](https://www.baeldung.com/axon-cqrs-event-sourcing)



