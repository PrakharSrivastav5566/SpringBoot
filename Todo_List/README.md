# Todo List API (Spring Boot + MongoDB)

## Prerequisites
- Java 21
- MongoDB running locally on `localhost:27017`
- Maven (or use the included wrapper)

## Quick Start
1. Make sure local MongoDB is running.
2. Run the app:
   ```powershell
   .\mvnw.cmd spring-boot:run
   ```
3. API base URL:
   `http://localhost:8080`

## Environment Variables
- `MONGODB_URI` (default: `mongodb://localhost:27017/ToDo`)
- `SERVER_PORT` (default: `8080`)

## Build and Test
```powershell
.\mvnw.cmd clean test
.\mvnw.cmd clean package
```

## API Endpoints

### Auth
- `POST /api/auth/register`
- `POST /api/auth/login`

Register/Login JSON:
```json
{
  "name": "John",
  "email": "john@example.com",
  "password": "secret123"
}
```

### Todos
- `GET /api/todos/{userId}`
- `POST /api/todos`
- `PUT /api/todos/{todoId}`
- `DELETE /api/todos/{todoId}?userId={userId}`

Create/Update Todo JSON:
```json
{
  "title": "Finish Spring Boot task",
  "description": "Complete API endpoints",
  "status": false,
  "userId": "<user-id>"
}
```

## Notes
- Validation errors and API exceptions are returned in a structured JSON format.
- Passwords are currently stored as plain text for simplicity. For production, hash passwords (for example with BCrypt).