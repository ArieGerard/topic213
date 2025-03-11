# Project Screenshots and Research Questions

## Section 1: Creating Data Services Using Spring JDBC

### Screenshot 
![alt text](<../images/Screenshot 2025-03-07 113448.jpg>)
**Description**: This screenshot shwos the orders page in the correct format without shwoing the orders from the database

## Section 2: Creating Data Services Using Spring Data JDBC.


### Screenshot
![alt text](<../images/Screenshot 2025-03-09 185851.jpg>)
**Description**: This screenshot shows the orders page populated from the database using Spring Data JDBC

## Section 3: Creating Data Services Using Spring Data JDBC Native Queries

### Screenshot
![alt text](<../images/Screenshot 2025-03-11 005816.jpg>)
**Description**: This screenshot shows the orders page populated from the database using the JDBC Native Queries

## Research Questions

### Research Question 1
**Question**: How does Spring Data JDBC differ from standard Java JDBC programming?
**Answer**: Spring Data JDBC differs from standard Java JDBC programming in several ways:

Simplified Configuration: Spring Data JDBC provides a simplified configuration process, reducing the amount of boilerplate code required to set up database connections and manage transactions.
Repository Abstraction: Spring Data JDBC introduces the concept of repositories, which provide a higher-level abstraction for data access operations. This allows developers to define repository interfaces and let Spring Data JDBC generate the implementation automatically.
Declarative Queries: Spring Data JDBC supports declarative queries using the @Query annotation, allowing developers to define custom SQL queries directly in the repository interface.
Entity Mapping: Spring Data JDBC provides built-in support for mapping Java objects to database tables, similar to JPA, but with a focus on simplicity and performance.
### Research Question 2
**Question**: How does Spring Data JDBC support transaction management and the ACID principle?
**Answer**: Spring Data JDBC supports transaction management and the ACID (Atomicity, Consistency, Isolation, Durability) principle through its integration with Spring's transaction management system. Key features include:

Declarative Transaction Management: Spring Data JDBC allows developers to use annotations like @Transactional to declaratively manage transactions, ensuring that database operations are executed within a transactional context.
Atomicity: Spring Data JDBC ensures that all operations within a transaction are treated as a single unit of work. If any operation fails, the entire transaction is rolled back, maintaining atomicity.
Consistency: Spring Data JDBC enforces data consistency by ensuring that all operations within a transaction adhere to the defined constraints and rules. If any operation violates these constraints, the transaction is rolled back.
