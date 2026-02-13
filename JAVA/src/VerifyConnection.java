import java.sql.Connection;
import java.sql.DriverManager;

public class VerifyConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Gyann"; 
        String user = "root";
        String password = "RajSingh3011@"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Verification Success: Java is talking to MySQL!");
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Verification Failed!");
            e.printStackTrace();
        }
    }
}