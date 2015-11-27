src_java        := BST.java MyBST.java
target_class	:= $(src_java:%.java=%.class)

all:run

%.class:%.java
	javac $<

run:$(target_class)
	java MyBST

.PHONY: all run clean
clean:
	rm -rf *.class *~
