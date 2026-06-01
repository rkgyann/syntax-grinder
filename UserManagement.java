import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManagement {
    
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/my_first_db";
    private static final String DB_USER = "vscode";
    private static final String DB_PASSWORD = "RajSingh3011@";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public static void main(String[] args) {
        Connection conn = null;
        
        try {
            // Step 1: Load MySQL JDBC Driver
            System.out.println("🔧 Loading MySQL JDBC Driver...");
            Class.forName(DB_DRIVER);
            System.out.println("✅ Driver loaded successfully!\n");
            
            // Step 2: Establish connection
            System.out.println("🔌 Connecting to MySQL database...");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("✅ Connected successfully!\n");
            
            // Step 3: Create table if not exists
            createTable(conn);
            
            // Step 4: Insert sample data
            insertData(conn);
            
            // Step 5: Display all data
            displayAllUsers(conn);
            
            // Step 6: Search for specific user
            searchUser(conn, 1);
            
            // Step 7: Update user
            updateUser(conn, 1, "John Updated");
            
            // Step 8: Delete user
            deleteUser(conn, 2);
            
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Step 9: Close connection
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("\n🔌 Database connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // Create users table
    private static void createTable(Connection conn) throws SQLException {
        System.out.println("📋 Creating table...");
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY, " +
                     "name VARCHAR(100) NOT NULL, " +
                     "email VARCHAR(100) UNIQUE, " +
                     "age INT)";
        
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        System.out.println("✅ Table created/verified!\n");
        stmt.close();
    }
    
    // Insert sample data
    private static void insertData(Connection conn) throws SQLException {
        System.out.println("📝 Inserting sample data...");
        String sql = "INSERT IGNORE INTO users (name, email, age) VALUES " +
                     "('John Doe', 'john@example.com', 25), " +
                     "('Jane Smith', 'jane@example.com', 28)";
        
        Statement stmt = conn.createStatement();
        int rowsInserted = stmt.executeUpdate(sql);
        System.out.println("✅ " + rowsInserted + " rows inserted!\n");
        stmt.close();
    }
    
    // Display all users
    private static void displayAllUsers(Connection conn) throws SQLException {
        System.out.println("📊 All Users in Database:");
        System.out.println("─────────────────────────────────────");
        
        String sql = "SELECT * FROM users";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            
            System.out.println("ID: " + id + " | Name: " + name + " | Email: " + email + " | Age: " + age);
        }
        System.out.println("─────────────────────────────────────\n");
        
        rs.close();
        stmt.close();
    }
    
    // Search for specific user
    private static void searchUser(Connection conn, int userId) throws SQLException {
        System.out.println("🔍 Searching for user ID: " + userId);
        
        String sql = "SELECT * FROM users WHERE id = " + userId;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        if (rs.next()) {
            System.out.println("✅ Found: " + rs.getString("name") + " (" + rs.getString("email") + ")\n");
        } else {
            System.out.println("❌ User not found!\n");
        }
        
        rs.close();
        stmt.close();
    }
    
    // Update user
    private static void updateUser(Connection conn, int userId, String newName) throws SQLException {
        System.out.println("✏️  Updating user ID " + userId + " to: " + newName);
        
        String sql = "UPDATE users SET name = '" + newName + "' WHERE id = " + userId;
        Statement stmt = conn.createStatement();
        int rowsUpdated = stmt.executeUpdate(sql);
        System.out.println("✅ " + rowsUpdated + " row(s) updated!\n");
        stmt.close();
    }
    
    // Delete user
    private static void deleteUser(Connection conn, int userId) throws SQLException {
        System.out.println("🗑️  Deleting user ID: " + userId);
        
        String sql = "DELETE FROM users WHERE id = " + userId;
        Statement stmt = conn.createStatement();
        int rowsDeleted = stmt.executeUpdate(sql);
        System.out.println("✅ " + rowsDeleted + " row(s) deleted!\n");
        stmt.close();
    }
}
