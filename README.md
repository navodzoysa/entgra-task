# Entgra Task

A Spring Boot application built to learn about API layer, Service layer and DAO layer.

## Getting Started

### Prerequisites to run this project for development

* JAVA JDK 8
* Apache Maven ~3.8.1
* Sprint Boot ~2.5.2
* MySQL Server ~8.0.25

### Steps to run locally

######There are two ways you can run this project:

1. Run ```mvn spring-boot:run``` in the terminal on the root directory

######or

1. Run ```mvn clean install``` in the root directory
2. Go to target folder using ```cd target```
3. Run ```java -jar entgra-task-0.0.1-SNAPSHOT.jar```

######Application will run on http://localhost:8080

### API

API endpoints can be tested using curl or Postman

* GET all devices - http://localhost:8080/device <br><br>
```curl -v http://localhost:8080/device``` <br><br>
* GET device - http://localhost:8080/device/{id} <br><br>
```curl -v http://localhost:8080/device/1``` <br><br>
* POST - http://localhost:8080/device <br><br>
```curl -v -X POST -H "Content-Type: application/json" -d "{ "name": "My Phone","model": "Oneplus","status": "ENROLLED","enrolledTime": "2020-11-07" }" http://localhost:8080/device``` <br><br>
* PUT - http://localhost:8080/device <br><br>
```curl -v -X PUT -H "Content-Type: application/json" -d "{ "id": "1","name": "My Phone","model": "Samsung","status": "INACTIVE","enrolledTime": "2021-12-30" }" "http://localhost:8080/device"``` <br><br>
* DELETE - http://localhost:8080/device/{id} <br><br>
```curl -v -X DELETE http://localhost:8080/device/1```

### Resources and Guides used to develop this project

The following guides illustrate how to use some features concretely:

* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [A Controller, Service and DAO Example with Spring Boot and JSF](https://www.baeldung.com/jsf-spring-boot-controller-service-dao)
* [Interface Driven Controllers in Spring](https://www.baeldung.com/spring-interface-driven-controllers)

