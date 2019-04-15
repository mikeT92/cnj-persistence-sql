# cnj-persistence-sql-backend-spring

Cloud native Java backend exposing REST endpoints protected by OpenID Connect security based on Spring Boot.
In this showcase, OpenID Connect security is added by using KeyCloak's Spring Boot Adapter.

## Build this application 

See [cnj-persistence-sql](../README.md) for build instructions.

``` 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing an Spring Boot application as Uber JAR.

## Exposed REST endpoints

### /api/v1/hello

Returns a simple welcome message to the currently authenticated user.

Method
: GET

URI
: /api/v1/hello

Parameter(s)
: none

Response
: welcome message as JSON document

Authentication type
: Bearer Token

Role(s) required
: CLOUDTRAIN_USER

## Exposed environment variables

TODO: still need to figure out, how KeyCloaks application properties can be turned into environment variables.

## Exposed Ports

| Port | Protocol | Description |
| --- | --- | --- |
| 8080 | HTTP | HTTP endpoint of this application | 
 
## Version / Tags

| Tag(s) | Remarks |
| --- | --- |
| latest, 1.0.0 | first release |
