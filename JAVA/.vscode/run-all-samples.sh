#!/bin/bash
set -e
cd "$(dirname "$0")"

echo "=== JAVA TicTacToe ==="
javac 'C Program/TicTacToe.java'
printf '1\n5\n2\n6\n3\n' | java -cp 'C Program' TicTacToe

printf '\n=== C hello ===\n'
gcc 'C Program/hello.c' -o 'C Program/hello'
'C Program/hello'

printf '\n=== C++ hello ===\n'
g++ 'C++ Program/hello.cpp' -o 'C++ Program/hello'
'C++ Program/hello'

printf '\n=== Python helloworld ===\n'
printf '6\n' | python3 'Python/python/helloworld.py'

printf '\n=== Node app.js ===\n'
node 'JavaScript/app.js'

printf '\n=== Node sum.js ===\n'
node 'JavaScript/sum.js'

printf '\n=== HTML parse ===\n'
python3 -c "from html.parser import HTMLParser; from pathlib import Path; text=Path('HTML/index.html').read_text(); parser=HTMLParser(); parser.feed(text); print('HTML parsed successfully')"

printf '\n=== MySQL root ===\n'
MYSQL_PWD='RajSingh3011@' mysql -h 127.0.0.1 -u root -e 'SELECT VERSION();'

printf '\n=== MySQL vscode ===\n'
MYSQL_PWD='RajSingh3011@' mysql -h 127.0.0.1 -u vscode -e 'SHOW DATABASES;'