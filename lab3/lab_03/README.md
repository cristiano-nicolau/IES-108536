# Lab 3.3 Notes

## Structure

* Controller 

* Service - Serv  

* Repository - 
    * MovieRepository extends JpaRepository<Movie, Long>
    * QuoteRepository extends JpaRepository<Quote, Long>

* Entity - 
    * Movie
    * Quote 


The controller is the entry point for the application. It is the first thing that is called when the application is run. The controller is responsible for handling the HTTP requests and responses. The controller calls the service which calls the repository which calls the database. The controller is the only thing that is exposed to the outside world. The service and repository are not exposed to the outside world. The service is responsible for the business logic. The repository is responsible for the database. The entity is the object that is stored in the database.

## API

* GET /quotes - returns all quotes
* GET /movies - returns all movies
* GET /movies/<id> - returns a movie by id
* GET /quotes/<id> - returns a quote by id
* POST /addmovie - creates a new movie
* POST /addquote - creates a new quote
* PUT /updatemovie/<id> - updates a movie by id
* PUT /updatequote/<id> - updates a quote by id
* DELETE /deletemovie/<id> - deletes a movie by id
* DELETE /deletequote/<id> - deletes a quote by id

# Dockerizig the application

## Dockerfile

```
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

## Docker commands

### Build the image


```bash
docker build -t movie_quote_api .
```

### Run the image

```bash
docker run --network=host  -p 8080:8080 movie_quote_api
```






