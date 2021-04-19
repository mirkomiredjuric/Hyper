# Spring Boot app for HR to manage employee

## Technology stack

- Java 8
- Spring Boot 2.4.5
- MySQL
- Docker
- Maven
- Lombok

## Installation

Set up mysql database via docker-compose from docker package

docker-compose up -d

### MySQL access params
-username: root
-password: testpass
-db: dev

In package data there is dev.sql file. Please, import that file and you will get two tables with some data inside.  
just import


### API endpoints

#### Employees

GET localhost:8080/api/employee
GET localhost:8080/api/employee/
GET localhost:8080/api/employee/*
GET localhost:8080/api/employee/all

returns all employees and their teams
*************************
GET localhost:8080/api/employee/allEmp

returns all employees with their id and name
**************************
GET localhost:8080/api/employee/{id}
GET localhost:8080/api/employee/get/{id}

returns specific employee and their team
**************
DELETE localhost:8080/api/employee/{id}
DELETE localhost:8080/api/employee/delete/{id}

delete only employee
********************
POST localhost:8080/api/employee

adding new employee without team

json example
{
"id": null,
"name": "Tijana",
"teamId": null
}

POST localhost:8080/api/employee

adding existing employee to the team

json example
{
"id": 987655,
"name": "Tijana",
"teamId": 2
}


#### Teams

GET localhost:8080/api/team
GET localhost:8080/api/team/
GET localhost:8080/api/team/*
GET localhost:8080/api/team/all

getting all teams with team lead

***********************
GET localhost:8080/api/team/1
GET localhost:8080/api/team/get/1

get team with team lead
*****

DELETE localhost:8080/api/team/1
DELETE localhost:8080/api/team/get/1

delete team
*****
POST localhost:8080/api/team

json example
{
"id": null,
"name": "HR",
"teamLeadId": null
}

adding new team
****
POST localhost:8080/api/team

json example

{
"id": 3,
"name": "HR",
"teamLeadId": 123456
}
****

