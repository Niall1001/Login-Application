# **Login Application**

This is a generic Spring Boot Application with React frontend which creates a boilerplate template for a logging in system.

## Description

It is a Logging in system for users to be able to register themselves to the application and have the ability to login and navigate to authroised endpoint:
>ADMIN - Admin User

>USER - Generic user type

## Requirements

>Java 17, Docker, React

## How do I run this application?

### Spin up backend

Once downloaded and have directed your unix based terminal to the root folder run:
```
docker-compose up
```
This docker script will create a docker image called `sailing-app` of the application enabling the DB to be spun up instantly along with populating the DB with dummy data. Run the API application locally using Java Spring Boot.

Once Complete, the backend application will be available through: (http://localhost:3000)

A list of available API endpoints are listed below:

> POST http://localhost:3000/v1/login

> POST http://localhost:3000/app-users/create

To Stop and remove the containers, ctrl + c out of the running docker-image and then run:
```
docker-compose down
docker volume prune
```

### Spin up frontend

Direct yourself back to the root of the project folder and issue the following command:
```
cd frontend
```
Once complete, issue the command:
```
npm install
```
This will download all the dependencies required to run the application successfully. Once completed, please issue the following command:
```
npm start
```

Producing:

```
`#RRGGBB Compiled successfully!`

You can now view sailing-app in the browser.

  Local:            http://localhost:3000
  On Your Network:  http://192.168.137.235:3000

Note that the development build is not optimized.
To create a production build, use npm run build.

webpack compiled successfully
```

## How do I run this application?

