# cnj-persistence-sql-backend-micro

Cloud native Java backend exposing REST endpoints protected by OpenID Connect security based on Eclipse MicroProfile.
In this showcase, OpenID Connect security is added by using MicroProfile JWT Auth.

## Build this application 

See [cnj-persistence-sql](../README.md) for build instructions.

``` 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing an Payara MicroProfile application as Uber JAR.

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

| Name | Required | Description |
| --- | --- | --- |
| MP_JWT_VERIFY_PUBLICKEY_LOCATION | x | REST endpoint of an OpenID Connect authentication provider returning the JWT key set |
| MP_JWT_VERIFY_ISSUER | x | ID of the JWT's issuer |


## Exposed Ports

| Port | Protocol | Description |
| --- | --- | --- |
| 8080 | HTTP | HTTP endpoint of this application | 
 
## Version / Tags

| Tag(s) | Remarks |
| --- | --- |
| latest, 1.0.0 | first release |
