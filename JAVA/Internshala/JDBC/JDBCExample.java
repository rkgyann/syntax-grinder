package JAVA.Internshala.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_first_db";
        String user = "vscode";
        String password = "RajSingh3011@";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");

            // Create statement
            Statement stmt = con.createStatement();

            // Example: Create table if not exists
            String createTableSQL = "CREATE TABLE IF NOT EXISTS example_table (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "age INT)";

            stmt.executeUpdate(createTableSQL);
            System.out.println("Table created or already exists.");

            // Insert data
            String insertSQL = "INSERT INTO example_table (name, age) VALUES ('John Doe', 30)";
            stmt.executeUpdate(insertSQL);
            System.out.println("Data inserted.");

            // Query data
            String selectSQL = "SELECT * FROM example_table";
            ResultSet rs = stmt.executeQuery(selectSQL);

            System.out.println("Data from table:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error!");
            e.printStackTrace();
        }
    }
}