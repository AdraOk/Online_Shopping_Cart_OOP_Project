# Online Shopping Cart
A project made for the EE1004 course at Marmara University

## Prebuilt Releases
Releases built by Github Actions can be obtained from the [releases](https://github.com/AdraOk/Online_Shopping_Cart_OOP_Project/releases) section of this repository.

These binaries are built fully automatically with no human intervention whatsoever, and can be trusted.

## Building Locally
Requires OpenJDK to be installed.

### Linux and UNIX
Included `Makefile` should work with all POSIX-compatible operating systems (**including MacOS X**)

Output file is `build/shoppingcart.jar` by default. This can be overridden by setting the `OUTJAR` make variable, like `make OUTJAR=name.jar build`

Build
```
make
```

Run
```
make run
```

Cleanup before action
```
make clean <build|run>
```

### Manual build for non-POSIX systems (incl. Windows)

1. Create a directory named `build`
2. Build the .class files using the Java Compiler
```
javac -d build Main.java Product.java ShoppingCart.java
```
3. Now you have the .class files compiled, link them together with the jar command
```
jar cfe build\out.jar Main -C build .
```
4. The resulting file is named `out.jar` and is located under the build directory. It can be run with the following command
```
java -jar build\out.jar
```
