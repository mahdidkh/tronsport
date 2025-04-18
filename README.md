# Transport Management System

A Spring Boot application for managing transportation logistics.

## Prerequisites

- Java 17
- Maven 3.8+
- MySQL 8.0
- Docker (optional)

## Environment Variables

The application uses the following environment variables:

- `DATABASE_URL`: JDBC URL for the MySQL database
- `DATABASE_USERNAME`: Database username
- `DATABASE_PASSWORD`: Database password
- `PORT`: Server port (default: 8080)

## Running Locally

### Using Maven

1. Clone the repository
2. Configure your database in `application.properties` or set environment variables
3. Run the application:

```bash
mvn spring-boot:run
```

### Using Docker

1. Clone the repository
2. Build and run using Docker Compose:

```bash
docker-compose up -d
```

## API Endpoints

The application exposes the following endpoints:

- `/api/auth/**`: Authentication endpoints
- `/api/shipments/**`: Shipment management endpoints

## Deployment

The application can be deployed to any platform that supports Java 17 applications.

### Using Docker

1. Build the Docker image:

```bash
docker build -t tronsport:latest .
```

2. Run the container:

```bash
docker run -p 8080:8080 \
  -e DATABASE_URL=jdbc:mysql://your-db-host:3306/tronsport_db \
  -e DATABASE_USERNAME=your-username \
  -e DATABASE_PASSWORD=your-password \
  tronsport:latest
```
