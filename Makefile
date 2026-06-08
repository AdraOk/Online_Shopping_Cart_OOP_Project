.PHONY: build

JAVAC = javac
SRC := *.java
BUILD_DIR = build
OUTJAR = shoppingcart.jar

build: build-class
	jar cfe $(BUILD_DIR)/$(OUTJAR) Main -C $(BUILD_DIR) .

build-class: mkbuilddir
	$(JAVAC) -d $(BUILD_DIR) $(SRC)

mkbuilddir:
	mkdir -p $(BUILD_DIR)

clean:
	rm -rf $(BUILD_DIR)

run: build
	java -jar $(BUILD_DIR)/$(OUTJAR)
