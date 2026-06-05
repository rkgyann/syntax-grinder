import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
    public void createDatabase() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_db","vscode","RajSingh3011@");
            System.out.println("Connected to MySQL database successfully!");
            
            // Create a statement object to execute SQL queries
            Statement stmt = con.createStatement();
            
            // You can add your SQL queries here
            // Example: stmt.executeUpdate("CREATE TABLE example (id INT PRIMARY KEY, name VARCHAR(50))");
            
            // Close the statement and connection
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyann","vscode","RajSingh3011@");
            System.out.println("Connected to MySQL database successfully!");
            
            // Create a statement object to execute SQL queries
            
            
            // You can add your SQL queries here
         /* String query ="create table Student(SId int(3), Name varchar(20), Email_Id varchar(200))";
            stmt.execute(query);
            System.out.println("Table Created Successfully");
            String query ="drop table Student";
            stmt.execute(query);
            System.out.println("Table Dropped Successfully");     */
            String a= "insert into Student value(?,?,?)";
            PreparedStatement pstm = con.prepareStatement(a);
            pstm.setInt(1, 10);
            pstm.setString(2, "Satyam");
            pstm.setString(3, "sandilya.satyam@gmail.com");

            pstm.execute();
            Statement stmt = con.createStatement();
            System.out.println("Data insterted Successfully");
            String ss ="desc Student";
            stmt.execute(ss);
         //   System.out.println("Table Created Successfully");
            // Example: stmt.executeUpdate("CREATE TABLE example (id INT PRIMARY KEY, name VARCHAR(50))");
            
            // Close the statement and connection
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }
}