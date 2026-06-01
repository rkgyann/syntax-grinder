#!/bin/bash
cd /Users/rkgyani/Library/CloudStorage/OneDrive-Personal
JDBC_JAR="/Users/rkgyani/Library/CloudStorage/OneDrive-Personal/JAVA/Internshala/JDBC/.vscode/mysql-connector-j-9.6.0.jar"

echo "🔨 Compiling UserManagement.java..."
javac -cp "$JDBC_JAR" UserManagement.java

if [ $? -eq 0 ]; then
    echo "✅ Compilation successful!"
    echo ""
    echo "▶️  Running UserManagement..."
    echo "════════════════════════════════════════"
    java -cp ".:$JDBC_JAR" UserManagement
else
    echo "❌ Compilation failed!"
    exit 1
fi
