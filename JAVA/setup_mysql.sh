#!/bin/bash

# MySQL + Java Setup Helper Script

echo "=================================="
echo "MySQL + Java Setup for VS Code"
echo "=================================="

# Check if MySQL is running
echo ""
echo "Checking MySQL status..."
if mysql.server status > /dev/null 2>&1; then
    echo "✓ MySQL is running"
else
    echo "✗ MySQL is not running"
    echo "Starting MySQL..."
    mysql.server start
fi

# Prompt for database creation
echo ""
echo "Would you like to create a sample database? (y/n)"
read -r response

if [[ "$response" == "y" || "$response" == "Y" ]]; then
    echo ""
    echo "Enter MySQL root password (leave empty if none):"
    read -rs mysql_password
    
    if [ -z "$mysql_password" ]; then
        mysql -u root -e "CREATE DATABASE IF NOT EXISTS my_first_db;"
    else
        mysql -u root -p"$mysql_password" -e "CREATE DATABASE IF NOT EXISTS my_first_db;"
    fi
    
    echo "✓ Database 'my_first_db' created or already exists"
fi

echo ""
echo "Setup complete! You can now use MySQL with Java."
echo "Run MySQLDatabase.java to test the connection."
