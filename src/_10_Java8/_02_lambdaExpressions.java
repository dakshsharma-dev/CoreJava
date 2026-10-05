package _10_Java8;

/*
    Lambda expression: anonymous implementation of a functional interface.      SYNTAX: (parameters) -> { body }

    // To convert a functional interface method implementation into a lambda:

    1. Remove modifiers (@Override, public, etc.)
    2. Remove method name
    3. Remove return type
    4. Add ->


    // Lambda Expression Rules

    // 1. If the body contains a single expression, curly braces {} can be omitted.
    (a, b) -> a + b

    // 2. Parameter types can usually be omitted (type inference). The compiler determines the types from the functional interface's method signature.
    (a, b) -> a + b

    // 3. If the body is a single expression that produces a value, the return keyword is implicit and can be omitted.
    (a, b) -> a + b

    // If the body contains multiple statements:
    // use {}.
    // return must be written explicitly(For non-void return types)
    (a, b) -> {
        int sum = a + b;
        return sum;
    }

    // 4. If there is exactly one parameter, parentheses can be omitted.
    x -> x * x

    // With multiple parameters, parentheses are required.
    (a, b) -> a + b


    // JAR file: Java Archive
    basically a compressed package containing compiled Java .class files and other resources.
    Lambdas reduce boilerplate source code -> potentially reducing JAR size.
*/
public class _02_lambdaExpressions {
}
