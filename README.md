AuthCore
=========

AuthCore is a lightweight authentication core built with Java 17 and Spring Boot. It demonstrates a clean domain-driven style with a hexagonal-like architecture using ports and adapters, powered by Spring Data JPA and Flyway migrations for PostgreSQL. The repository focuses on a user domain and provides a minimal, extensible foundation for authentication-related functionality.

Key technologies
- Java 17
- Spring Boot (Spring Web MVC, Data JPA, Security OAuth2 client)
- PostgreSQL
- Flyway for database migrations
- Lombok (optional)
- Maven build

What you’ll find inside
- Domain model: UserModel (domain layer)
- Application ports: UserUseCase (inbound), UserRepositoryCase (outbound)
- Adapters: REST controller, persistence adapters, mappers
- Persistence: JPA repository (JpaUserRepository)
- Migrations: Flyway configuration and migrations (via Flyway dependency)
- Tests: Basic test scaffolding in src/test

Project structure (high level)
- pom.xml: Maven configuration and Spring Boot dependencies
- src/main/java/com/core/AuthCore/: Core application entry and domain logic
- src/main/java/com/core/AuthCore/application/port/in/: Inbox ports (use cases)
- src/main/java/com/core/AuthCore/infraestructure/adapters/out/persistence/: Persistence adapters (JPA repositories)
- src/main/java/com/core/AuthCore/infraestructure/adapters/dto/: Request/Response DTOs (CreateUserRequest, UserResponse, etc.)
- src/main/resources/: Project resources (application.properties, etc.)
- src/main/test/: Test suites

How to run locally
Prerequisites
- Java 17 (JDK)
- Maven
- PostgreSQL (or another compatible database)

1) Configure the database
- Create a PostgreSQL database, for example: `authcore`.
- Create a user and grant privileges as needed.
- Update the application properties with your DB credentials (below is a typical example).

2) Run the application
- From the project root: `mvn clean package`
- Then: `java -jar target/AuthCore-0.0.1-SNAPSHOT.jar` (or `mvn spring-boot:run` for a run-from-source workflow)

On startup, Flyway migrations will be applied automatically to seed the database schema if migrations are present.

Configuration tips
- application.properties currently defines the application name. To connect to your database, you typically add:
  spring.datasource.url=jdbc:postgresql://localhost:5432/authcore
  spring.datasource.username=your_username
  spring.datasource.password=your_password
- You can also configure JPA/Hibernate properties, or use Spring Boot’s defaults if you prefer.

REST API surface (typical usage)
- The project models a User domain with a REST-facing controller. Typical operations available (depending on routing):
  - Create user: POST /users with CreateUserRequest payload
  - Get all users: GET /users
  - Get a user by id: GET /users/{id}
  - Update user: PUT /users/{id} with updated User payload
  - Delete user: DELETE /users/{id}
Notes:
- The exact endpoints and payload field names are defined by the controller and DTO classes in the codebase (e.g., CreateUserRequest, UserResponse).
- The inbound port is UserUseCase, which drives domain logic; the outbound port(s) handle persistence via JpaUserRepository.

Code highlights (key classes)
- AuthCoreApplication: Spring Boot app entry point.
- UserModel: Domain representation of a user.
- UserUseCase: Inbound port declaring core user-related actions.
- JpaUserRepository: JPA repository for UserModel.
- UserController: REST controller exposing user operations.
- CreateUserRequest / UserResponse: DTOs for request/response payloads.

Extending the project
- Add new domain capabilities by extending the domain model, ports, and adapters.
- Introduce new REST endpoints by adding controllers and updating DTOs, then wire them through the existing ports.
- Add database migrations under src/main/resources/db/migration as Flyway SQL scripts.

Tests
- Tests live under src/test. They exercise the application’s layers and ensure the ports interact correctly with adapters.

License
- No license is declared in this repository snapshot. If you plan to use or contribute, consider adding a license file.

Contact
- This project is kept in the AuthCore repository. Please open issues or PRs for enhancements, bug fixes, or questions.

Note
- The package naming uses a mix of English and Portuguese in some directories (e.g., infraestructure). Functions and classes adhere to the actual codebase naming.
