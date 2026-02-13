.PHONY: compile run clean

compile:
	javac -cp "mysql-connector-j-9.6.0.jar" jdbc_connect.java

run: compile
	java -cp ".:mysql-connector-j-9.6.0.jar" jdbc_connect

clean:
	rm -f *.class
