src_java        := Edge.java Node.java Algorithm.java ShortestPath.java
target_class	:= $(src_java:%.java=%.class)

all:run

%.class:%.java
	javac $<

run:$(target_class)
	java ShortestPath

.PHONY: all run clean
clean:
	rm -rf *.class *~
