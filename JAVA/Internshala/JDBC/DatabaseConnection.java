package JAVA.Internshala.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnection utility class for MySQL JDBC connections
 * Uses vscode user with stable credentials
 */
public class DatabaseConnection {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/my_first_db";
    private static final String DB_USER = "vscode";
    private static final String DB_PASSWORD = "RajSingh3011@";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }
    }
    
    /**
     * Get a MySQL database connection
     * @return Connection object to my_first_db
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to MySQL database successfully!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Failed to connect to MySQL database");
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * Close database connection safely
     * @param conn Connection to close
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing connection");
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        // Test connection
        try {
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("✓ Test connection successful!");
                closeConnection(conn);
            }
        } catch (SQLException e) {
            System.out.println("✗ Test connection failed!");
            e.printStackTrace();
        }
    }
}
