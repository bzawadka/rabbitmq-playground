# rabbitmq-playground

## Example 1 - named queue
one (or more) producer, one (or more) consumer

##### Consumer / Receiver
start one or more `RabbitPlaygroundApplication` or

`java -jar build/libs/rabbit-playground-0.0.1-SNAPSHOT.jar --spring.profiles.active=example-1,receiver`

##### Producer / Sender
`java -jar build/libs/rabbit-playground-0.0.1-SNAPSHOT.jar --spring.profiles.active=example-1,sender`

## Example 2 - work queues
distributing tasks among workers
[competing consumers](https://www.enterpriseintegrationpatterns.com/patterns/messaging/CompetingConsumers.html) pattern


