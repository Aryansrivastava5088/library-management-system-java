# 📚 Library Management System (Java + JDBC + MySQL)

This is a console based Library Management System developed using Java, JDBC, and MySQL.  
The project demonstrates how Java applications interact with databases to perform CRUD operations.

##  Features

- Add new books
- View all books
- Issue books
- Return books
- Database connectivity using JDBC
- PreparedStatement for secure queries

## Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- VS Code

## Database Structure

Database: `library`

Table: `books`

| Column | Type | Description |
|--------|------|-------------|
| id | INT | Primary Key (Auto Increment) |
| title | VARCHAR | Book title |
| author | VARCHAR | Author name |
| issued | BOOLEAN | Book status |



1. Install MySQL and create database:

```sql
CREATE DATABASE library;
USE library;

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    author VARCHAR(100),
    issued BOOLEAN DEFAULT FALSE
);
