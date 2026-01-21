import java.sql.*;

public class MySQLDatabase {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/my_first_db";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Change this to your MySQL password

    public static void main(String[] args) {
        // Step 1: Test the connection
        try (Connection conn = getConnection()) {
            System.out.println("✓ Connection to MySQL database established successfully!");

            // Step 2: Create a sample table (if not exists)
            createTable(conn);

            // Step 3: Insert sample data
            insertData(conn, "John Doe", "john@example.com");
            insertData(conn, "Jane Smith", "jane@example.com");

            // Step 4: Retrieve and display data
            retrieveData(conn);

        } catch (SQLException e) {
            System.err.println("✗ Connection failed!");
            e.printStackTrace();
        }
    }

    // Method to establish connection
    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Method to create a sample table
    public static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "email VARCHAR(100) NOT NULL)";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✓ Table 'users' created or already exists.");
        }
    }

    // Method to insert data
    public static void insertData(Connection conn, String name, String email) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("✓ Inserted: " + name + " (" + email + ")");
        }
    }

    // Method to retrieve data
    public static void retrieveData(Connection conn) throws SQLException {
        String sql = "SELECT * FROM users";

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Users in Database ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("ID: " + id + " | Name: " + name + " | Email: " + email);
            }
        }
    }
}
