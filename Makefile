.PHONY: build

JAVAC = javac
SRC := $(wildcard *.java)
BUILD_DIR = build
OUTJAR = shoppingcart.jar

build: build-class
	jar cf $(BUILD_DIR)/$(OUTJAR) $(BUILD_DIR)/*.class

build-class: mkbuilddir
	$(JAVAC) -d $(BUILD_DIR) $(SRC)

mkbuilddir:
	mkdir -p $(BUILD_DIR)

clean:
	rm -rf $(BUILD_DIR)

run: build
	java -jar $(BUILD_DIR)/$(OUTJAR)
