Stuff Manager
===================
Stuff Manager provides a REST API for retrieval of stuff.
stuff data is persisted in a relational database system and mapped to Entity classes
using JPA. Via Service and Repository classes (and interfaces), a REST controller
has access to stuff data.
The application uses Spring Boot, which makes it easy to create stand-alone,
production-grade Spring based Applications that you can "just run".

The physical relational data model consists of two tables. PROJECT has a ONE-TO-MANY relation with STUFF.:

The db script can be found in:

    stuff-manager/src/main/resources/db/migration/V1__init.sql

Software requirements
=====================

    - Maven 3.x
    - JDK 1.7+

Running the application
=======================
You can run the application using

    mvn spring-boot:run

Or you can build the JAR file with

    mvn clean package

and run the JAR by typing:

    java -jar target/stuff-manager-0.1.0.jar

Using the REST API
==================
Examples:

Getting stuff for a project:

    GET: http://localhost:8080/sysapi/v1/stuff?projectId=1

Creating stuff (not tested yet)

    POST: http://localhost:8080/sysapi/v1/stuff


TO-DOs (enhancements for upcoming releases)
===========================================

    - Add Integration tests for REST controller
    - Input validation
    - Improved exception handling and logging
    - Business rules?


