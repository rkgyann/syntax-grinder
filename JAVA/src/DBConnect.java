import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) {
        // Database URL
        String DB_URL = "jdbc:mysql://localhost:3306/my_first_db";
        String USER = "root";
        String PASS = "your_password"; // <<< REPLACE THIS >>>

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connection established successfully!");
            // You can now execute SQL statements using this 'conn' object
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}