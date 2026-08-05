# AWS Product API - Architecture Design

## Overview

This project is a Spring Boot REST API for product management.

The application exposes the following endpoints:

- POST /api/v1/product
- GET /api/v1/product
- GET /api/v1/product/{id}

The application is containerized using Docker and designed to run on AWS.

---

# Architecture

Internet
↓
Application Load Balancer
↓
Amazon ECS Fargate
↓
Product API Container
↓
Amazon RDS PostgreSQL

---

# Components

## Amazon ECR

Stores Docker images.

Responsibilities:

- Application image storage
- Version management

---

## Amazon ECS Fargate

Runs the application container.

Why Fargate?

- No server management
- Automatic scaling
- Simplified operations

---

## Amazon RDS PostgreSQL

Managed relational database service.

Why RDS?

- Automated backups
- Managed maintenance
- High availability options
- Monitoring

---

## Application Load Balancer

Distributes incoming traffic.

Responsibilities:

- HTTP/HTTPS routing
- Health checks
- High availability

---

# Deployment Flow

Developer
↓
GitHub Repository
↓
Docker Build
↓
Amazon ECR
↓
Amazon ECS Fargate
↓
Amazon RDS PostgreSQL

---

# Security Considerations

## ECS

The application should run in private subnets.

## Database

RDS should not be publicly accessible.

## Secrets

Database credentials should be stored in:

- AWS Secrets Manager

or

- AWS Systems Manager Parameter Store

---

# Scalability

The ECS Service can scale horizontally.

Example:

1 Container
↓
3 Containers
↓
10 Containers

without changes to application code.

---

# Future Improvements

- CloudWatch Monitoring
- Auto Scaling Policies
- Terraform
- CI/CD with GitHub Actions
- Multi-AZ RDS
- Amazon ElastiCache Redis
