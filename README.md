# tdc-2019
API Composition - A Microservices Pattern

Microservices patterns from Chris Richardson's [Microservices Patterns](https://www.manning.com/books/microservices-patterns) book.

Once you apply the Database Per Service pattern, you may face a challenge to "join" data from different databases.

The API Composition pattern addresses this by combining 2 (or more) services by joining their APIs.

In this example, I have implemented the pattern using [Project Reactor](https://projectreactor.io/docs/core/release/reference/) and WebClient from [Spring Webflux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html).