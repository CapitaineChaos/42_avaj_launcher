JDK_DIR := /tmp/jdk
JAVA    := $(JDK_DIR)/bin/java
JAVAC   := $(JDK_DIR)/bin/javac

export JAVA_HOME := $(JDK_DIR)
export PATH := $(JDK_DIR)/bin:$(PATH)

all: install_jdk compile run

install_jdk:
	@if [ ! -x "$(JAVA)" ] || [ ! -x "$(JAVAC)" ]; then \
		echo "Installing OpenJDK into $(JDK_DIR)..."; \
		bash scripts/install_jdk.sh; \
		echo "OpenJDK installed successfully.\n\n"; \
	fi
	@echo "java  = $$($(JAVA) --version | head -n1)"
	@echo "javac = $$($(JAVAC) --version | head -n1)"

compile:
	@find * -name "*.java" > sources.txt
	@$(JAVAC) @sources.txt

run:
	@$(JAVA) app.simulator.Scenario

clean:
	@find . -name "*.class" -delete
	@rm -f sources.txt

.PHONY: install_jdk compile run clean
