package JAVA.FirstCode;
import java.sql.*;

public class StudentManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Gyann";
        String user = "root"; 
        String password = "RajSingh3011@";

        String insertSql = "INSERT IGNORE INTO Student (RollNo, Name, Marks, City) VALUES (?, ?, ?, ?)";
        String selectSql = "SELECT RollNo, Name, Marks, City FROM Student ORDER BY RollNo";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Safe INSERT (ignores duplicates)
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                pstmt.setInt(1, 101);
                pstmt.setString(2, "Gyanendra");
                pstmt.setInt(3, 85);
                pstmt.setString(4, "Dehradun");
                
                int rowsAffected = pstmt.executeUpdate();
                System.out.println(rowsAffected > 0 ? "✅ Inserted/Updated!" : "ℹ️ Record already exists");
            }

            // Always show table
            try (PreparedStatement pstmt = conn.prepareStatement(selectSql);
                 ResultSet rs = pstmt.executeQuery()) {

                System.out.println("📋 Student table:");
                System.out.printf("+--------+%-10s+%-6s+%-10s+%n", "--------", "--------", "----------");
                System.out.printf("| %-6s | %-9s | %-5s | %-8s |%n", "RollNo", "Name", "Marks", "City");
                System.out.printf("+--------+%-10s+%-6s+%-10s+%n", "--------", "--------", "----------");

                while (rs.next()) {
                    System.out.printf("| %-6d | %-9s | %-5d | %-8s |%n",
                        rs.getInt("RollNo"), rs.getString("Name"), 
                        rs.getInt("Marks"), rs.getString("City"));
                }
                System.out.printf("+--------+%-10s+%-6s+%-10s+%n", "--------", "--------", "----------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}