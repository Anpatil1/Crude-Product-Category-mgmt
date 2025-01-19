# Category-Product Management System

A RESTful Spring Boot application that manages categories and products with pagination support and relational database integration.

## Tech Stack

- **Spring Boot**: Core framework
- **Spring Data JPA & Hibernate**: ORM and database operations
- **MySQL/PostgreSQL**: Relational database (configurable)
- **Spring REST**: RESTful API implementation
- **Maven**: Dependency management and build tool

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           ├── controller/
│   │           │   ├── CategoryController.java
│   │           │   └── ProductController.java
│   │           ├── model/
│   │           │   ├── Category.java
│   │           │   └── Product.java
│   │           ├── repository/
│   │           │   ├── CategoryRepository.java
│   │           │   └── ProductRepository.java
│   │           ├── service/
│   │           │   ├── CategoryService.java
│   │           │   └── ProductService.java
│   │           └── Application.java
│   └── resources/
│       └── application.properties
```

## Database Configuration

Add the following properties to `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## API Endpoints

### Category APIs

1. **Get All Categories (Paginated)**
   - Method: GET
   - URL: `/api/categories?page={pageNumber}`
   - Response: Page of categories

2. **Create Category**
   - Method: POST
   - URL: `/api/categories`
   - Body:
     ```json
     {
         "name": "Electronics",
         "description": "Electronic items"
     }
     ```

3. **Get Category by ID**
   - Method: GET
   - URL: `/api/categories/{id}`

4. **Update Category**
   - Method: PUT
   - URL: `/api/categories/{id}`
   - Body:
     ```json
     {
         "name": "Updated Electronics",
         "description": "Updated description"
     }
     ```

5. **Delete Category**
   - Method: DELETE
   - URL: `/api/categories/{id}`

### Product APIs

1. **Get All Products (Paginated)**
   - Method: GET
   - URL: `/api/products?page={pageNumber}`
   - Response: Page of products with category details

2. **Create Product**
   - Method: POST
   - URL: `/api/products`
   - Body:
     ```json
     {
         "name": "Laptop",
         "description": "High-performance laptop",
         "price": 999.99,
         "categoryId": 1
     }
     ```

3. **Get Product by ID**
   - Method: GET
   - URL: `/api/products/{id}`
   - Response: Product with category details

4. **Update Product**
   - Method: PUT
   - URL: `/api/products/{id}`
   - Body:
     ```json
     {
         "name": "Updated Laptop",
         "description": "Updated description",
         "price": 1099.99,
         "categoryId": 1
     }
     ```

5. **Delete Product**
   - Method: DELETE
   - URL: `/api/products/{id}`

## Key Features

1. **Entity Relationships**
   - One-to-Many relationship between Category and Products
   - Each Product belongs to one Category
   - Each Category can have multiple Products

2. **Pagination**
   - Server-side pagination implemented for both Categories and Products
   - Default page size: 10 items
   - Customizable page size using `size` parameter

3. **Data Transfer**
   - Products fetched with their respective Category details
   - Proper error handling and validation

## Setup Instructions

1. Clone the repository
2. Configure database properties in `application.properties`
3. Run `mvn clean install`
4. Start the application: `mvn spring-boot:run`
5. Access the APIs at `http://localhost:8080`

## Testing

Use Postman or any REST client to test the APIs:

1. Create a Category first
2. Create Products under that Category
3. Test pagination by accessing `/api/products?page=0&size=10`
4. Verify one-to-many relationship by fetching a Product

## Error Handling

The application includes proper error handling for:
- Resource not found
- Invalid input data
- Database constraints
- Server errors

## Notes

- Ensure proper database setup before running the application
- Use appropriate HTTP methods as specified
- Pagination is mandatory for list operations
- Category details are included in Product responses
