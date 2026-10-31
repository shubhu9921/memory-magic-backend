# Memory Magic Backend (Spring Boot 3)

The backend service for **Memory Magic** — a cross-platform memory-matching game for children, teenagers, and adults.

## 🚀 Tech Stack

- **Java**: 17
- **Framework**: Spring Boot 3.2.5
- **ORM / Persistence**: Spring Data JPA & Hibernate
- **Database**: PostgreSQL (Production) / H2 (Testing)
- **Database Migrations**: Flyway
- **Validation**: Jakarta Validation
- **Monitoring**: Spring Boot Actuator
- **Testing**: JUnit 5, Mockito, Spring WebMvcTest
- **Containerization**: Docker (multi-stage build)
- **Deployment Platform**: Render

---

## 📂 Project Architecture

```
memory-magic-backend/
├── Dockerfile
├── render.yaml
├── pom.xml
├── .env.example
├── src/
│   ├── main/
│   │   ├── java/com/memorymagic/backend/
│   │   │   ├── common/             # Common API wrappers & models
│   │   │   ├── config/             # CORS and Web configurations
│   │   │   ├── controller/         # REST API endpoints
│   │   │   ├── dto/                # Request & response representations
│   │   │   ├── entity/             # JPA domain entities
│   │   │   ├── exception/          # Global exception handling
│   │   │   ├── repository/         # Spring Data JPA repositories
│   │   │   ├── service/            # Core business logic & services
│   │   │   └── MemoryMagicBackendApplication.java
│   │   └── resources/
│   │       ├── application.yml     # Base configuration
│   │       ├── application-dev.yml # Local development profile
│   │       ├── application-prod.yml# Production profile (Render + Postgres)
│   │       └── db/migration/       # Flyway schema migrations
│   └── test/
│       ├── java/com/memorymagic/backend/ # Unit & Slice tests
│       └── resources/application-test.yml# In-memory H2 test config
```

---

## 🛠️ API Endpoints (Week 1 Foundation)

| Method | Endpoint | Description | Response Example |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/health` | Service health status check | `{"success": true, "message": "Memory Magic backend is running", "status": "UP"}` |
| `GET` | `/api/v1/app/info` | Application metadata | `{"success": true, "application": "Memory Magic", "version": "1.0.0", "environment": "development"}` |
| `GET` | `/actuator/health` | Spring Boot Actuator health probe | `{"status": "UP"}` |

---

## 💻 Local Development Setup

### Prerequisites
- JDK 17 or higher (`java -version`)
- Apache Maven 3.8+ (`mvn -version`)
- PostgreSQL (optional for local testing; H2 in-memory is configured for tests)

### Running Locally

1. Clone or navigate to the backend repository:
   ```bash
   cd memory-magic-backend
   ```

2. Copy the environment variables example:
   ```bash
   cp .env.example .env
   ```

3. Run unit tests:
   ```bash
   mvn test
   ```

4. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

5. Test the health endpoint:
   ```bash
   curl http://localhost:8080/api/v1/health
   ```

---

## 🐳 Docker Build

Build and run the container locally:

```bash
docker build -t memory-magic-backend:latest .
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=dev memory-magic-backend:latest
```

---

## ☁️ Render Deployment Instructions

### Option 1: Automatic Blueprint (Recommended)
1. In your [Render Dashboard](https://dashboard.render.com/), click **New** -> **Blueprint**.
2. Connect your Git repository containing `render.yaml`.
3. Render will provision:
   - PostgreSQL Database: `memory-magic-db`
   - Web Service: `memory-magic-backend`
4. The database credentials and connection string are automatically injected into the web service.

### Option 2: Manual Web Service Setup
1. Create a **PostgreSQL** database named `memory_magic_db` on Render.
2. Create a **Web Service** with Docker runtime pointing to `memory-magic-backend`.
3. Set the following environment variables:
   - `PORT`: `8080`
   - `SPRING_PROFILES_ACTIVE`: `prod`
   - `SPRING_DATASOURCE_URL`: `jdbc:postgresql://<RENDER_PG_HOST>:5432/memory_magic_db`
   - `SPRING_DATASOURCE_USERNAME`: `<DB_USER>`
   - `SPRING_DATASOURCE_PASSWORD`: `<DB_PASSWORD>`
   - `CORS_ALLOWED_ORIGINS`: `https://<YOUR_NETLIFY_APP_NAME>.netlify.app`
4. Set Health Check Path to: `/actuator/health`.

