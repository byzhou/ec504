src_java        := Edge.java Node.java Algorithm.java ShortestPath.java
target_class	:= $(src_java:%.java=%.class)

all:run

#%.class:%.java
#	javac $<

ShortestPath.class: $(src_java)
	javac $(src_java)

run: ShortestPath.class
	java ShortestPath

.PHONY: all run clean
clean:
	rm -rf *.class *~
