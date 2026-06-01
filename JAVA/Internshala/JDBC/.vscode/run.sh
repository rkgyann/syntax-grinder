#!/bin/bash

# Change to script directory
cd "$(dirname "$0")"

# Set the JDBC driver path
JDBC_JAR="/Users/rkgyani/Library/CloudStorage/OneDrive-Personal/Attachments/mysql-connector-j-9.6.0/mysql-connector-j-9.6.0.jar"

# Compile
echo "Compiling..."
javac -cp "$JDBC_JAR" jdbc_connect.java

# Run
echo "Running..."
java -cp ".:$JDBC_JAR" jdbc_connect
