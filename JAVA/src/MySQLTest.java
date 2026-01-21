import java.sql.*;

public class MySQLTest {
    public static void main(String[] args) {
        System.out.println("=== Java MySQL JDBC Test ===\n");

        // Test 1: Check if JDBC Driver is available
        testJDBCDriver();

        // Test 2: Test database connection
        testDatabaseConnection();
    }

    public static void testJDBCDriver() {
        System.out.println("Test 1: Checking MySQL JDBC Driver...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✓ MySQL JDBC Driver loaded successfully!\n");
        } catch (ClassNotFoundException e) {
            System.out.println("✗ MySQL JDBC Driver not found!");
            System.out.println("  Error: " + e.getMessage() + "\n");
        }
    }

    public static void testDatabaseConnection() {
        System.out.println("Test 2: Testing Database Connection...");

        String DB_URL = "jdbc:mysql://localhost:3306/my_first_db";
        String USER = "root";
        String PASSWORD = ""; // Empty password - adjust if needed

        System.out.println("Connection Details:");
        System.out.println("  Database URL: " + DB_URL);
        System.out.println("  Username: " + USER);
        System.out.println("  Password: " + (PASSWORD.isEmpty() ? "[empty]" : "[set]"));
        System.out.println();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            System.out.println("✓ Successfully connected to MySQL database!");

            // Get database metadata
            DatabaseMetaData metadata = conn.getMetaData();
            System.out.println("\nDatabase Information:");
            System.out.println("  Driver: " + metadata.getDriverName());
            System.out.println("  Version: " + metadata.getDriverVersion());
            System.out.println("  Database URL: " + metadata.getURL());

        } catch (SQLException e) {
            System.out.println("✗ Connection failed!");
            System.out.println("  Error Code: " + e.getErrorCode());
            System.out.println("  Error Message: " + e.getMessage());
            System.out.println("\nPossible solutions:");
            System.out.println("  1. Ensure MySQL server is running: mysql.server status");
            System.out.println("  2. Update PASSWORD in this file with your MySQL password");
            System.out.println("  3. Check if database 'my_first_db' exists");
        }
    }
}
