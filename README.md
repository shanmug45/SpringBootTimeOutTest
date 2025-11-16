# Spring Boot Timeout Demo

This is a Spring Boot application that demonstrates configurable delays and timeouts for API endpoints.

## Endpoints

### 1. POST /double
Accepts a number and returns its double value with timing information.

**Request:**
```json
{
  "number": 10
}
```

**Response:**
```json
{
  "Input": 10,
  "result": 20,
  "delay": 1000,
  "timeout": 5000,
  "actualDuration": 1001,
  "timestamp": "2025-11-13T19:10:10.4676"
}
```

### 2. PUT /delay
Sets the delay for the `/double` endpoint in milliseconds.

**Request:**
```json
{
  "milliseconds": 1000
}
```

### 3. PUT /timeout
Sets the timeout value for the `/double` endpoint in milliseconds. If the delay exceeds the timeout, a 500 error is returned.

**Request:**
```json
{
  "milliseconds": 5000
}
```

## Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

The application will start on port 8080.

## Testing

```bash
# Set delay to 1 second
curl -X PUT http://localhost:8080/delay -H "Content-Type: application/json" -d '{"milliseconds":1000}'

# Set timeout to 5 seconds
curl -X PUT http://localhost:8080/timeout -H "Content-Type: application/json" -d '{"milliseconds":5000}'

# Call the double endpoint
curl -X POST http://localhost:8080/double -H "Content-Type: application/json" -d '{"number":10}'

# Test timeout (set timeout < delay)
curl -X PUT http://localhost:8080/timeout -H "Content-Type: application/json" -d '{"milliseconds":500}'
curl -X POST http://localhost:8080/double -H "Content-Type: application/json" -d '{"number":10}'
```
