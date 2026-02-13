package JAVA.Internshala.JDBC;

public class jdbc_insert {
    
    public static void main(String[] args) {
        
        try (Connection conn = getConnection()) {
            System.out.println("✓ Connection to MySQL database established successfully!");

        } catch (SQLException e) {
            System.err.println("✗ Connection failed!");
            e.printStackTrace();
        }
    }
}
