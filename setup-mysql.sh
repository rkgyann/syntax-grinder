#!/bin/bash

# MySQL Auto-Start Script for VS Code workspace
# Run this once to set up automatic MySQL startup

echo "🔧 Setting up MySQL automatic startup..."

# Ensure MySQL is installed via Homebrew
if ! command -v brew &> /dev/null; then
    echo "❌ Homebrew is not installed. Please install it first."
    exit 1
fi

# Check if MySQL is installed
if ! brew list mysql &> /dev/null; then
    echo "❌ MySQL is not installed via Homebrew."
    exit 1
fi

# Start MySQL service
echo "▶️  Starting MySQL service..."
brew services start mysql

# Verify service is running
if brew services list | grep -q "mysql.*started"; then
    echo "✓ MySQL service started successfully!"
else
    echo "⚠️  MySQL service status unknown"
fi

# Test connection with vscode user
echo ""
echo "🧪 Testing database connection..."
export MYSQL_PWD='RajSingh3011@'

if mysql -h 127.0.0.1 -u vscode -e "SELECT VERSION();" &> /dev/null; then
    echo "✓ Database connection test passed!"
else
    echo "❌ Database connection test failed"
fi

# Show databases
echo ""
echo "📦 Available databases:"
mysql -h 127.0.0.1 -u vscode -e "SHOW DATABASES;" | grep -E "my_first_db|Gyann|Satyam|libraby"

echo ""
echo "✅ MySQL setup complete!"
echo ""
echo "Next steps:"
echo "1. Open OneDrive-Personal.code-workspace in VS Code"
echo "2. Install recommended extensions from the prompt"
echo "3. Open SQLTools and connect to 'Local MySQL (vscode)'"
echo ""
