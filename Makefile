all:
	make prepare
	make build
	make run

prepare:
	@echo "Preparing the project..."
	find * -name '*.java' > sources.txt
	@echo "Preparation complete."

build:
	@echo "Building the project..."
	 javac @sources.txt
	@echo "Build complete."

run:
	java ro.academyplus.avaj.simulator.Simulator scenario.txt

.PHONY: prepare all run
