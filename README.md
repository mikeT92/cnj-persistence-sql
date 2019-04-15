# cnj-persistence-sql

Showcase of a "Hello-World" style cloud native Java application using OpenID Connect for REST endpoint protection.
The actual integration of OpenID Connect security is demonstrated with three different Java backend technologies:
* Java EE (see: cnj-persistence-sql-backend-javaee)
* Eclipse MicroProfile (see: cnj-persistence-sql-backend-micro)
* Spring Boot (see: cnj-persistence-sql-backend-spring)

In this showcase, KeyCloak is used as an OpenID Connect Authentication Provider. 
An pre-configured KeyCloak instance is provided [here](https://github.com/mikeT92/cnj-docker-keycloak).

## Build this showcase 

### Prerequisites

In order to run the build, you have to install the following tools locally:
* Docker
* Docker Compose 
* Maven
* Java JDK 8

### Run Maven

You can build all showcase applications by running Maven:
```
mvn clean install -P pre-commit-stage
```

The Maven build will create Docker images for all showcase applications and run system tests on them.