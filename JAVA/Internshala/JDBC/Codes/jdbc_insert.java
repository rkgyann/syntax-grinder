import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc_insert {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_db","vscode","RajSingh3011@"))
            System.out.println("Connection to MySQL database established successfully!");

        } catch (SQLException e) {
            System.err.println("Connection failed!");
            e.printStackTrace();
        }
    }
}