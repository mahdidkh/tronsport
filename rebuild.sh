#!/bin/bash

# Clean up
./mvnw clean

# Build the project
./mvnw package -DskipTests

echo "Build completed. The JAR file is in the target directory."
echo "You can deploy to Render by pushing to your Git repository."
