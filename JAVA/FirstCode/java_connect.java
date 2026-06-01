package JAVA.Internshala.JDBC.Codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_connect {
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_db","vscode","RajSingh3011@");
            System.out.println("Connected to MySQL database successfully!");
            
            // Create a statement object to execute SQL queries
            Statement stmt = con.createStatement();
            
            // You can add your SQL queries here
            // Example: stmt.executeUpdate("CREATE TABLE example (id INT PRIMARY KEY, name VARCHAR(50))");
            
            // Close the statement and connection
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }
}
