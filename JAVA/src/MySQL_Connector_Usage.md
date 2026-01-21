# MySQL Connector/J

MySQL Connector/J is the official JDBC driver for MySQL. It allows Java applications to connect to MySQL databases using the JDBC API.

## Downloading MySQL Connector/J
1. Go to the [MySQL Connector/J download page](https://dev.mysql.com/downloads/connector/j/).
2. Select the appropriate version for your operating system.
3. Download the ZIP or TAR file.
4. Extract the downloaded file to access the JAR file (e.g., `mysql-connector-java-x.x.x.jar`).

## Adding the Driver to Your Project
To use the MySQL JDBC driver in your Java project, you need to include it in your classpath when compiling and running your Java application.

### Command Line Example
When compiling and running your Java program, use the following commands:
```bash
# Replace 'mysql-connector-java-x.x.x.jar' with the actual JAR file name
javac -cp .:mysql-connector-java-x.x.x.jar DBConnect.java
java -cp .:mysql-connector-java-x.x.x.jar DBConnect
```

### IDE Configuration
If you are using an IDE like IntelliJ IDEA or Eclipse, you can add the JAR file to your project libraries through the project settings.

## Example Code
Here is an example of how to connect to a MySQL database:
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://localhost:3306/my_first_db";
        String USER = "root";
        String PASS = "your_password"; // <<< REPLACE THIS >>>

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
```