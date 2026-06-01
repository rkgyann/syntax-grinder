import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mysql";
        String user = "root";
        String password = "your_password";

        try {
            Connection con =
                    DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}