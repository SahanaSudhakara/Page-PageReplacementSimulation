# Define the Java compiler
JAVAC = javac

# Define the Java compiler flags
JFLAGS = -g

# Define the target and dependencies
TARGET = DriverClass
DEPENDENCIES = DriverClass.java

# Define the default make target
default: compile

# Target for compiling the Java program
compile:
	$(JAVAC) $(JFLAGS) $(DEPENDENCIES)

# Target for cleaning up compiled files
clean:
	rm -f $(TARGET).class
