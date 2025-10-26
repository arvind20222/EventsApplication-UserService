# -------------------- STAGE 1: BUILDER --------------------
# Use full JDK to build the application
FROM eclipse-temurin:17-jdk-alpine AS builder

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for caching dependencies)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Download dependencies offline (improves caching)
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Build the application (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# -------------------- STAGE 2: RUNNER --------------------
# Use lightweight JRE to run the application
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the compiled JAR from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port (your app runs on 7001)
EXPOSE 7001

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
