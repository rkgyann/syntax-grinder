# JDBC Connection Example

## Setup

1. **MySQL Configuration**
   - Host: localhost:3306
   - Database: my_first_db
   - User: root
   - Password: HiBixby3011

2. **JDBC Driver**
   - Jar file: `mysql-connector-j-9.6.0.jar` (already in this directory)

## How to Run

### Option 1: Using Makefile (Recommended)
```bash
make run       # Compile and run
make compile   # Only compile
make clean     # Remove .class files
```

### Option 2: Using VS Code
- Press `Ctrl+Shift+B` (or `Cmd+Shift+B` on Mac) to run the default build task
- The task will compile and run the JDBC program

### Option 3: Manual Command Line
```bash
javac -cp "mysql-connector-j-9.6.0.jar" jdbc_connect.java
java -cp ".:mysql-connector-j-9.6.0.jar" jdbc_connect
```

## Output
The program will:
1. Load the MySQL JDBC driver
2. Connect to `my_first_db` database
3. Display all tables in the database

```
Connected to the database successfully!

Tables in 'my_first_db':
  - Users
```

## Troubleshooting

- **"Driver not found"**: Make sure `mysql-connector-j-9.6.0.jar` is in the same directory
- **"Access denied"**: Check the password in `jdbc_connect.java` (line 11)
- **"Unknown database"**: Verify the database name is correct (currently: `my_first_db`)
