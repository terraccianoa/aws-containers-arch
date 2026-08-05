# AWS contaniner arch

Spring Boot REST API deployed on AWS using a cloud-native architecture.

## Features

- Create Product
- Get Product By Id
- Get All Products

## Endpoints

POST /api/v1/product --> api that saves a single product into DB postgreSQL

GET /api/v1/product --> api that retrives a product by id from DB table

GET /api/v1/product/{id} --> api that retrives all product from DB table

## Stack

- Java 21
- Spring Boot 3
- PostgreSQL
- Docker
- Amazon ECS Fargate
- Amazon RDS PostgreSQL
- Application Load Balancer
- Amazon ECR

## Architecture

Internet
↓
ALB
↓
ECS Fargate
↓
Spring Boot Container
↓
RDS PostgreSQL

## AWS Services

### Amazon ECR

Stores Docker images.

### Amazon ECS Fargate

Runs containers without managing servers.

### Amazon RDS PostgreSQL

Managed relational database.

### Application Load Balancer

Routes HTTP traffic to ECS tasks.
