# RunnerController

## Description
The `RunnerController` class is part of the `io.hullaert.acrho.controller` package and serves as a REST controller to manage operations related to "runners" in the application. It leverages Spring Boot annotations to expose REST APIs for retrieving and deleting runners based on their unique IDs (`runnerId`).

---

## API Endpoints

### 1. Retrieve a Runner by ID (`runnerId`)
- **HTTP Method**: `GET`
- **Path**: `/runner/{runnerId}`
- **Description**: Fetches the details of a runner based on the provided ID.

#### Features
1. Calls the `findById(runnerId)` method of the `RunnerRepository` to retrieve the runner's details.
2. If no runner is found, a custom exception `RunnerNotFoundException` is thrown.

#### Parameters
| Name        | Type   | Description                              |
|-------------|--------|------------------------------------------|
| `runnerId`  | `long` | The unique ID of the runner to retrieve. |

#### Responses
- **200 (OK)**: The runner is found, and their details are returned in a JSON response.
- **400 (Bad Request)**: The provided ID is invalid.
- **404 (Not Found)**: No runner was found with the provided ID.

---

### 2. Delete a Runner by ID (`runnerId`)
- **HTTP Method**: `DELETE`
- **Path**: `/runner/{runnerId}`
- **Description**: Deletes a runner from the database based on the provided ID.

#### Features
1. Calls the `deleteById(runnerId)` method in the `RunnerRepository` to remove the runner from the database.
2. If the ID is invalid or the runner doesn't exist, Spring's exception handling may deal with the error.

#### Parameters
| Name        | Type   | Description                              |
|-------------|--------|------------------------------------------|
| `runnerId`  | `long` | The unique ID of the runner to delete.   |

#### Responses
- **200 (OK)**: Successfully deleted.

---

## Exception Management
### `RunnerNotFoundException`
This exception is thrown when the provided `runnerId` does not match any runner in the database. It results in a `404 (Not Found)` HTTP response.

---

## Technologies and Annotations Used
### **Spring Boot**
- `@RestController`: Declares the class as a REST API controller.
- `@Autowired`: Injects dependencies, such as `RunnerRepository`.
- `@PathVariable`: Maps the `{runnerId}` in the URL to a method parameter.
- `@GetMapping` and `@DeleteMapping`: Define routes for HTTP requests.

### **Swagger/OpenAPI**
- `@Operation`: Provides a summary of the API.
- `@ApiResponse`: Describes possible HTTP responses for each endpoint.
- `@Schema`: Adds metadata for the model used in the API documentation.

---

## Swagger Example - OpenAPI Documentation

```yaml
paths:
  /runner/{runnerId}:
    get:
      summary: Retrieve a runner by ID
      tags:
        - Runners
      parameters:
        - in: path
          name: runnerId
          schema:
            type: integer
          required: true
          description: The ID of the runner to retrieve
      responses:
        '200':
          description: Runner found
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Runner'
        '400':
          description: Invalid ID supplied
        '404':
          description: Runner not found
    delete:
      summary: Delete a runner by ID
      tags:
        - Runners
      parameters:
        - in: path
          name: runnerId
          schema:
            type: integer
          required: true
          description: The ID of the runner to delete
      responses:
        '200':
          description: Successfully deleted
```

---

## Dependencies
The `RunnerController` uses constructor-based dependency injection to include the `RunnerRepository`, which manages database operations for `Runner` entities.

---

## Prerequisites
- **Java 17** (or later).
- Spring Boot.
- Tools like **Swagger** for API documentation.

---

## How to Run the Application
1. Ensure Maven/Gradle dependencies are correctly set up.
2. Build and start the Spring Boot application.
3. Access the Swagger interface at `http://localhost:8080/swagger-ui.html` to explore and test the APIs.

---

## Author
This class is developed as part of the runner services for the **ACRHO** application (Association des Courses).

---

## License
This project is licensed under the **MIT License**. See the `LICENSE` file for details.