# VS Code + MySQL Setup Guide

## ✅ Setup Status: COMPLETE

Your workspace is now configured with permanent VS Code + MySQL integration.

---

## 📦 Available Databases

```
Gyann
libraby
my_first_db (Primary database for JDBC projects)
Satyam
information_schema
mysql
performance_schema
sys
```

---

## 🔐 MySQL Credentials

| User | Password | Privileges |
|------|----------|-----------|
| root | RajSingh3011@ | Full (DBA) |
| vscode | RajSingh3011@ | Full (for VS Code work) |

**Connection Details:**
- Host: `127.0.0.1`
- Port: `3306`
- Default Database: `my_first_db`

---

## 🚀 Quick Start

### Option 1: Open Workspace (Recommended)
```bash
# Open the workspace file in VS Code
open OneDrive-Personal.code-workspace
```

### Option 2: Manual Setup
1. Open VS Code in this folder
2. Install recommended extensions (popup will appear)
3. Open SQLTools sidebar (Ctrl+Shift+P → "SQLTools: Open Connection Explorer")
4. Click "Local MySQL (vscode)" to connect

---

## 📂 Files Created

| File | Purpose |
|------|---------|
| `OneDrive-Personal.code-workspace` | Workspace configuration with SQLTools settings |
| `.vscode/settings.json` | VS Code settings with MySQL connections |
| `.vscode/extensions.json` | Recommended extensions list |
| `mysql-config.json` | JSON config for apps to read MySQL details |
| `setup-mysql.sh` | Script to auto-start MySQL and verify connection |
| `JAVA/Internshala/JDBC/DatabaseConnection.java` | Reusable JDBC utility class |

---

## ✏️ Updated JDBC Files

Your Java JDBC files have been updated to use the **vscode** user and **my_first_db** database:

- `JAVA/Internshala/JDBC/Codes/java_connect.java`
- `JAVA/Internshala/JDBC/JDBCExample.java`
- `JAVA/Internshala/JDBC/Codes/jdbc_insert.java`

---

## 🔧 Using DatabaseConnection Utility

**Instead of hardcoding connection details, use this reusable class:**

```java
import JAVA.Internshala.JDBC.DatabaseConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class MyApp {
    public static void main(String[] args) {
        try {
            // Get connection
            Connection conn = DatabaseConnection.getConnection();
            
            // Use connection
            Statement stmt = conn.createStatement();
            // ... your SQL code here
            
            // Close connection
            DatabaseConnection.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 🧪 Testing Connections

### From Terminal
```bash
# Test root connection
MYSQL_PWD='RajSingh3011@' mysql -u root -e "SELECT VERSION();"

# Test vscode connection
MYSQL_PWD='RajSingh3011@' mysql -u vscode -e "SHOW DATABASES;"

# Run setup verification
./setup-mysql.sh
```

### From VS Code
1. Click SQLTools icon (sidebar)
2. Click "Local MySQL (vscode)"
3. Expand database tree
4. Right-click and test query

---

## 🔄 MySQL Auto-Start

MySQL is configured to **start automatically** on system boot via Homebrew:

```bash
# Check service status
brew services list

# Restart MySQL if needed
brew services restart mysql

# Stop MySQL
brew services stop mysql
```

---

## 🆘 Troubleshooting

### MySQL Connection Fails
```bash
# Check if MySQL is running
brew services list

# Start it manually
brew services start mysql

# Test connection
MYSQL_PWD='RajSingh3011@' mysql -u vscode -e "SELECT VERSION();"
```

### "Driver not found" in Java
- Ensure `mysql-connector-j-9.6.0.jar` is in classpath
- Found in: `/Users/rkgyani/Library/CloudStorage/OneDrive-Personal/Attachments/mysql-connector-j-9.6.0/`

### SQLTools Not Showing Connections
- Install "SQLTools" extension
- Install "SQLTools MySQL/MariaDB" driver
- Reload VS Code window (Ctrl+Shift+P → "Reload Window")

### Wrong Database in JDBC
- Verify `my_first_db` exists: `mysql -u vscode -e "SHOW DATABASES;"`
- Create if missing: `mysql -u root -e "CREATE DATABASE my_first_db;"`

---

## 📋 Checklist for Tomorrow

- [ ] Open `OneDrive-Personal.code-workspace` in VS Code
- [ ] Install recommended extensions (SQLTools + driver)
- [ ] Test MySQL connection via SQLTools
- [ ] Run your JDBC code with `DatabaseConnection` utility
- [ ] All databases should be visible in SQLTools explorer

---

## 💡 Pro Tips

1. **Use DatabaseConnection class** for all JDBC connections instead of hardcoding
2. **Workspace opens automatically** with MySQL settings
3. **run `./setup-mysql.sh`** if you ever experience connection issues
4. **SQLTools queries** can be saved as `.sql` files in your workspace
5. **Keep `mysql-config.json`** synced if deploying to other machines

---

## ✨ What's Permanent

✅ MySQL service auto-starts on boot  
✅ VS Code workspace remembers MySQL connections  
✅ JDBC code updated to use stable vscode user  
✅ DatabaseConnection utility available  
✅ All credentials configured in workspace files  

**No more manual setup needed!** 🎉

