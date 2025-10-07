# User Login & Registration with Email Validation

A Spring Boot application that provides user authentication and registration functionality with email validation.

## Features

- User registration with email validation
- Email-based account activation
- JWT-based authentication
- Secure password encryption
- Role-based access control
- PostgreSQL database integration
- RESTful API endpoints
- OpenAPI/Swagger documentation

## Tech Stack

- **Java**: 25
- **Spring Boot**: 3.5.6
- **Spring Security**: JWT-based authentication
- **Spring Data JPA**: Database operations
- **PostgreSQL**: 17.5 (Alpine)
- **Hibernate**: ORM
- **Lombok**: Boilerplate code reduction
- **JavaMailSender**: Email functionality
- **MailDev**: Email testing
- **Docker Compose**: Container orchestration
- **H2 Database**: In-memory database for testing
- **OpenAPI/Swagger**: API documentation (v2.5.0)

## Prerequisites

- Java 25 or higher
- Maven 3.6+
- Docker and Docker Compose
- Git

## Getting Started

### 1. Clone the repository

```bash
git clone <repository-url>
cd User-Login-Registration-with-Email-validation
```

### 2. Start Docker containers

Start PostgreSQL and MailDev using Docker Compose:

```bash
docker-compose up -d
```

This will start:

- PostgreSQL on port `5433`
- MailDev on ports `1080` (web UI) and `1025` (SMTP)

### 3. Build the project

```bash
mvn clean install
```

Or to skip tests:

```bash
mvn clean install -DskipTests
```

### 4. Run the application

```bash
mvn spring-boot:run
```

Or run with the dev profile:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

The application will start on `http://localhost:8080/api/v1`

### 5. Access API Documentation

Once the application is running, access the Swagger UI at:

```
http://localhost:8080/api/v1/swagger-ui.html
```

### 6. Access MailDev

View emails sent by the application at:

```
http://localhost:1080
```

## Configuration

### Application Properties

The application uses profile-based configuration:

#### Development Profile (`application-dev.yml`)

- **Database**: PostgreSQL on localhost:5433
- **Mail Server**: MailDev on localhost:1025
- **Server Port**: 8080
- **Context Path**: /api/v1
- **JWT Expiration**: 24 hours (86400000 ms)

### Environment Variables

You can override the following properties using environment variables:

- `SPRING_DATASOURCE_URL`: Database URL
- `SPRING_DATASOURCE_USERNAME`: Database username
- `SPRING_DATASOURCE_PASSWORD`: Database password
- `SPRING_MAIL_HOST`: Mail server host
- `SPRING_MAIL_PORT`: Mail server port
- `JWT_SECRET_KEY`: JWT secret key
- `MAILING_FRONTEND_ACTIVATION_URL`: Frontend activation URL

## API Endpoints

### Authentication

#### Register a new user

```http
POST /api/v1/auth/register
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "password": "securePassword123"
}
```

#### Activate account

```http
GET /api/v1/auth/activate-account?token={activation-token}
```

#### Login

```http
POST /api/v1/auth/login
Content-Type: application/json

{
  "email": "john.doe@example.com",
  "password": "securePassword123"
}
```

## Database Schema

The application uses the following main entities:

- **User**: Stores user information (first name, last name, email, password)
- **Role**: Manages user roles and permissions
- **Token**: Handles activation and authentication tokens

## Testing

### Run all tests

```bash
mvn test
```

### Run tests with coverage

```bash
mvn clean test jacoco:report
```

The application uses H2 in-memory database for testing to ensure tests are isolated and fast.

## Docker Services

### PostgreSQL

- **Container**: postgres-sql-bsn
- **Image**: postgres:17.5-alpine3.22
- **Port**: 5433:5432
- **Database**: book_social_network
- **Credentials**: postgres/postgres

### MailDev

- **Container**: mail-dev-bsn
- **Image**: maildev/maildev
- **Web UI**: http://localhost:1080
- **SMTP Port**: 1025

### Start services

```bash
docker-compose up -d
```

### Stop services

```bash
docker-compose down
```

### View logs

```bash
docker-compose logs -f
```

## Security

- Passwords are encrypted using BCrypt
- JWT tokens are used for authentication
- Tokens expire after 24 hours
- Email verification is required for account activation
- Role-based access control for endpoints

## Build and Package

### Create executable JAR

```bash
mvn clean package
```

The JAR file will be created in the `target` directory:

```
target/book-network-0.0.1-SNAPSHOT.jar
```

### Run the JAR

```bash
java -jar target/book-network-0.0.1-SNAPSHOT.jar
```

## CI/CD

The project includes GitHub Actions workflow for continuous integration. See `.github/workflows/maven.yml` for details.

## Troubleshooting

### Port already in use

If port 5433 or 8080 is already in use:

```bash
# Check what's using the port
lsof -i :5433
lsof -i :8080

# Kill the process or change the port in configuration
```

### Database connection issues

Ensure PostgreSQL container is running:

```bash
docker ps | grep postgres
```

If not running, start it:

```bash
docker-compose up -d postgres
```

### Email not sending

Check MailDev is running:

```bash
docker ps | grep maildev
```

Access MailDev web UI at http://localhost:1080 to verify emails.

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── masayuki/book_network/
│   │       ├── auth/              # Authentication services
│   │       ├── config/            # Configuration classes
│   │       ├── controller/        # REST controllers
│   │       ├── email/             # Email services
│   │       ├── role/              # Role management
│   │       ├── security/          # Security configuration
│   │       └── user/              # User entities and repositories
│   └── resources/
│       ├── application.yml        # Main configuration
│       ├── application-dev.yml    # Development configuration
│       └── templates/             # Email templates
└── test/
    ├── java/                      # Test classes
    └── resources/
        └── application.yml        # Test configuration
```

## License

This project is a demo application for learning purposes.

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Support

For issues and questions, please create an issue in the GitHub repository.
