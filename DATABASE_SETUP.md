# Database Setup Instructions

Before running the application, you need to set up the database user and schema. Follow these steps:

## Using MySQL Command Line

1. Open MySQL command line client (or use MySQL Workbench)
2. Login as root:
   ```
   mysql -u root
   ```
3. Run the following commands:
   ```sql
   -- Create the database if it doesn't exist
   CREATE DATABASE IF NOT EXISTS tronsport_db;

   -- Create the user if it doesn't exist
   CREATE USER IF NOT EXISTS 'tronsport'@'localhost' IDENTIFIED BY 'mahdi3629A';

   -- Grant privileges to the user
   GRANT ALL PRIVILEGES ON tronsport_db.* TO 'tronsport'@'localhost';

   -- Apply the changes
   FLUSH PRIVILEGES;
   ```

## Using the SQL Script

Alternatively, you can run the SQL script provided in the project:

1. Navigate to the project directory
2. Run the following command:
   ```
   mysql -u root < src/main/resources/db/setup-user.sql
   ```

## Verify the Setup

To verify that the user and database were created correctly:

1. Login with the new user:
   ```
   mysql -u tronsport -p
   ```
   When prompted, enter the password: `mahdi3629A`

2. Check if you can access the database:
   ```sql
   USE tronsport_db;
   SHOW TABLES;
   ```

## Application Configuration

The application is already configured to use this database in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tronsport_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=tronsport
spring.datasource.password=mahdi3629A
```
