#!/bin/bash

# Run java_connect in the background and connect to MySQL
cd /Users/rkgyani/Library/CloudStorage/OneDrive-Personal/JAVA/FirstCode

# Compile
javac -cp ../mysql-connector-j-9.6.0.jar java_connect.java

# Run in background and log output
nohup java -cp ../mysql-connector-j-9.6.0.jar:. java_connect > ../java_connect.log 2>&1 &

echo "Java MySQL connection started in background. Check ../java_connect.log for output."
