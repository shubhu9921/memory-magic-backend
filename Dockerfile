# Stage 1: Build the Spring Boot application
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder
WORKDIR /app

# Copy pom.xml and pre-fetch dependencies for better build caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build production artifact
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Minimal runtime image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Add non-root system user and group for security
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copy built JAR from builder stage
COPY --from=builder /app/target/memory-magic-backend-1.0.0.jar app.jar

# Adjust permissions
RUN chown -R appuser:appgroup /app

USER appuser

# Render sets the PORT environment variable at runtime (defaults to 8080 if not provided)
ENV PORT=8080 \
    SPRING_PROFILES_ACTIVE=prod \
    JAVA_TOOL_OPTIONS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

EXPOSE 8080

# Execute Spring Boot app
ENTRYPOINT ["sh", "-c", "java $JAVA_TOOL_OPTIONS -Dserver.port=${PORT} -jar app.jar"]
