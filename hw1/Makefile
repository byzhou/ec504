src_java        := MySolution.java
target_class	:= $(src_java:%.java=%.class)

all:run

%.class:%.java
	javac $<

run:$(target_class)
	java MySolution

.PHONY: all run clean
clean:
	rm -rf *.class *~
