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

# Run the application with optimized JVM settings
CMD ["java", "-Xms256m", "-Xmx512m", "-XX:+UseG1GC", "-XX:+UseContainerSupport", "-Dspring.profiles.active=prod", "-Dserver.port=8080", "-Dspring.datasource.hikari.connection-timeout=60000", "-Dspring.datasource.hikari.maximum-pool-size=5", "-jar", "target/tronsport-0.0.1-SNAPSHOT.jar"]
