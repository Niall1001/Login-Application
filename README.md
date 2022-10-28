# **Login Application**

This is a generic Spring Boot Application with React frontend which creates a boilerplate template for a logging in system.

## Description

It is a Logging in system for users to be able to register themselves to the application and have the ability to login and navigate to authroised endpoint:
>ADMIN - Admin User

>USER - Generic user type

## Requirements

>Java 17, Docker, React

## How do I run this application?

Once downloaded and have directed your unix based terminal to the root folder run:
```
docker-compose up
```
This docker script will create a docker image called `sailing-app` of the application enabling the DB to be spun up instantly along with populating the DB with dummy data. Run the API application locally using Java Spring Boot.

Once Complete, the application will be available through: (http://localhost:8090)

To Stop and remove the containers, ctrl + c out of the running docker-image and then run:

```
docker-compose down
docker volume prune
```


