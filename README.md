# Employee Performance Management System

## Overview

The Employee Performance Management System is a Spring Boot application designed to manage employee performance data. It deals with data Retrieval in Employee Performance Management System.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Installation](#installation)
  - [Configuration](#configuration)
- [Usage](#usage)
  - [Running the Application](#running-the-application)
  - [API Documentation](#api-documentation)

## Features

- **Employee Management**: CRUD operations for employees.
- **API Documentation**: Swagger UI for API documentation.

## Prerequisites

- Java Development Kit (JDK) 17
- Apache Maven
- H2 Database (for development)

## Getting Started

### Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/yourusername/EmployeePerformanceManagementSystem.git
   cd EmployeePerformanceManagementSystem
   ```

2. Build the project using Maven:

   ```sh
   ./mvnw clean install
   ```

### Configuration

The application uses the following configuration properties:

- `spring.datasource.url`: JDBC URL for the H2 database.
- `spring.datasource.username`: Username for the H2 database.
- `spring.datasource.password`: Password for the H2 database.
- `spring.jpa.hibernate.ddl-auto`: Hibernate DDL auto setting.

You can configure these properties in the `application.properties` file located in `src/main/resources`.

## Usage

### Running the Application

To run the application, use the following command:

```sh
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

### API Documentation

The API documentation is available via Swagger UI. You can access it at:

http://localhost:8080/swagger-ui.html
