all:run_string

compile:
	javac binarysum.java
	javac myStringAnalyser.java

run_binary:compile
	java binarysum temp.txt

run_string:compile
	java myStringAnalyser abababaaa 1

clean:
	rm -rf *.class *~
