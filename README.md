# SpringBoot-Rest-Application-Demo

This application exposes endpoints to perform CRUD operations on customer and employee data.

**Customer EndPoint** - This resource will persist and mantain the data using H2 InMemory Database.

**Employee EndPoint** - This resource will persist and maintain the data in [External Public API](http://dummy.restapiexample.com) 
http://dummy.restapiexample.com


*[Note: Public API URI configuration have to be configured in application.properties file. Otherwise application will fails on startup]*

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [SpringBoot 2.1.5](https://spring.io/projects/spring-boot)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.ing.springboot.SpringBootRestApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Application EndPoints

Below are the list of API which will be exposed to interact.

**Base URL**  : **http://localhost:8080/SBDemo/api/v1**  

*[Note : The above domain URL will vary based on the environment profiles. Also we can configured the port in property files]*

**CustomerEndPoint API List :**

| Operations           | URI                     | Method       |
| -------------------- | ----------------------- | ------------ |
| **ADD Customer**     | `/add/customer`         | **POST**     |
| **GET Customer**     | `/get/customer/{id}`    | **GET**      |
| **DELETE Customer**  | `/delete/customer/{id}` | **DELETE**   |

**EmployeeEndPoint API List :**

| Operations           | URI                     | Method       |
| -------------------- | ----------------------- | ------------ |
| **ADD Employee**     | `/add/employee`         | **POST**     |
| **GET Employee**     | `/get/employee/{id}`    | **GET**      |


**Application Swagger URL :**

*Please check the below swagger URL for more details about the API EndPoints* 


[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

*[Note: Before accessing the above swagger URL make sure the application is up and running locally.]*


## Copyright

Released under the Apache License 2.0. See the [LICENSE]() file.
