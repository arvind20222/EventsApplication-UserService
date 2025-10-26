# Use a lightweight JDK 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy source code
COPY src ./src

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the app (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Copy the built jar
COPY target/UserService-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render will assign PORT environment variable)
EXPOSE 7001

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
