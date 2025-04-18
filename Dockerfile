FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Fix for Alpine Linux
RUN apk add --no-cache bash

# Copy Maven wrapper and pom.xml
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Make mvnw executable
RUN chmod +x ./mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw package -DskipTests

# Expose port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/tronsport-0.0.1-SNAPSHOT.jar"]
