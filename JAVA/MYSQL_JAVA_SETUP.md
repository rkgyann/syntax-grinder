# Java + MySQL Setup Guide

Your Java environment is now ready to work with MySQL databases!

## What Has Been Set Up:

### 1. **MySQL JDBC Driver**

- **Location**: `/libs/mysql-connector-j-8.2.0.jar`
- **Version**: 8.2.0
- This is the official MySQL connector for Java

### 2. **VS Code Configuration**

- VS Code is configured to automatically include the MySQL JDBC driver in your classpath
- The `.vscode/settings.json` file has been updated to reference the driver

### 3. **Sample Java File**

- **File**: `src/MySQLDatabase.java`
- Demonstrates how to:
  - Connect to a MySQL database
  - Create tables
  - Insert data
  - Retrieve and display data

## Setup Instructions:

### Step 1: Set MySQL Password (Important!)

```bash
mysql.server stop
mysql_secure_installation
mysql.server start
```

During `mysql_secure_installation`:

- When asked "Would you like to set the root password?", choose **Yes**
- Enter a password (remember it!)

### Step 2: Update Your Java Code

In any Java file that connects to MySQL, update the password:

```java
private static final String PASSWORD = "your_password"; // Replace with your MySQL root password
```

### Step 3: Compile and Run

In the terminal, use these commands:

```bash
# Navigate to your Java source directory
cd src

# Compile (with MySQL driver in classpath)
javac -cp "../libs/mysql-connector-j-8.2.0.jar" YourFile.java

# Run (with MySQL driver in classpath)
java -cp "../libs/mysql-connector-j-8.2.0.jar:." YourFile
```

### Step 4: Create Your Database

```bash
# Login to MySQL (with password prompt)
mysql -u root -p

# Inside MySQL prompt:
CREATE DATABASE my_first_db;
EXIT;
```

## How to Use in VS Code:

1. Open VS Code with your JAVA folder
2. Open any `.java` file with MySQL code
3. Use **Ctrl+Shift+`** to open the terminal
4. Run the compile and execute commands as shown above

## Example Connection Code:

```java
import java.sql.*;

try (Connection conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/my_first_db",
    "root",
    "your_password")) {
    System.out.println("Connected to MySQL!");

    // Execute SQL queries here
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

} catch (SQLException e) {
    e.printStackTrace();
}
```

## Troubleshooting:

### "No suitable driver found"

- Make sure you're using the correct classpath: `-cp "../libs/mysql-connector-j-8.2.0.jar"`

### "Access denied for user 'root'@'localhost'"

- Set the MySQL root password using `mysql_secure_installation`
- Update the PASSWORD variable in your Java code

### "Unknown database"

- Create the database first using: `CREATE DATABASE my_first_db;`

## Next Steps:

1. Set up MySQL password (Step 1 above)
2. Try running the sample `MySQLDatabase.java` file
3. Learn SQL queries and integrate them into your Java applications
4. Explore more complex database operations (CRUD, transactions, etc.)

Happy Learning!
