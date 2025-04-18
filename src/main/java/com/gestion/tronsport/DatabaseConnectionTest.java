package com.gestion.tronsport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/tronsport_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String username = "root";
            String password = "";
            
            // Establish the connection
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            
            // Create a statement
            Statement statement = connection.createStatement();
            
            // Execute a query to check tables
            System.out.println("Checking tables...");
            ResultSet tables = statement.executeQuery("SHOW TABLES");
            
            // Print the tables
            System.out.println("Tables in the database:");
            while (tables.next()) {
                System.out.println(tables.getString(1));
            }
            
            // Check shipments table
            System.out.println("\nChecking shipments table...");
            ResultSet shipments = statement.executeQuery("SELECT COUNT(*) FROM shipments");
            if (shipments.next()) {
                System.out.println("Number of shipments: " + shipments.getInt(1));
            }
            
            // Check users table
            System.out.println("\nChecking users table...");
            ResultSet users = statement.executeQuery("SELECT COUNT(*) FROM users");
            if (users.next()) {
                System.out.println("Number of users: " + users.getInt(1));
            }
            
            // Close the connection
            connection.close();
            System.out.println("\nDatabase connection closed.");
            
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
