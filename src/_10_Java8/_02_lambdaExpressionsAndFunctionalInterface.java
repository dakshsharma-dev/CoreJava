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

    // 2. Parameter types can usually be omitted (type inference).
    //    The compiler determines the types from the functional interface's method signature.
    (a, b) -> a + b

    // 3. If the body is a single expression that produces a value,
    //    the return keyword is implicit and can be omitted.
    (a, b) -> a + b

    // If the body contains multiple statements, use {}.
    // For non-void return types, return must be written explicitly.
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

@FunctionalInterface // restricts the interface to be a functional interface -> will throw compile-time error if try to add another abstract method
interface MyInterface{
    void sayHello();

    // default methods are concrete methods in interface, default is not package-private modifier, both are different things: no-modifier and default method in interface
    default void hii(){
        System.out.println("Hii!!");
    }

    static void hey(){
        System.out.println("Hey!!");
    }
    // there are no restrictions on the NUMBER OF default or static methods.
}

// Inheritance in functional interface
@FunctionalInterface
interface Child extends MyInterface{         // this too is a functional interface
    void sayHello(); // it's upto us we can redefine it or not


    default void hii(){           // default methods are ONLY FOR INTERFACES, it is not the same as package-private access
        System.out.println("Hii from Child interface");
    }

    // @Override // static methods can't be overridden
    static void hey(){                        // Same name, same signature as parent but no overriding, no hiding, no inheritance relationship. They just happen to have the same name(they are independent methods)
        System.out.println("Hey from child interface");
    }
}

class Class1 implements MyInterface{
    public void sayHello(){
        System.out.println("hello ji!!");
    }
    // Interface methods are implicitly public abstract.
    // Therefore, the implementing method must also be public.


}

public class _02_lambdaExpressionsAndFunctionalInterface {
    public static void main(String[] args) {

        // implementing functional interface via anonymous inner class
        MyInterface test = new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("Hello");
            }
        };
        test.sayHello();


        // using lambda expression instead of anonymous inner class
        MyInterface test1 = () -> System.out.println("Hello");
        test1.sayHello();
        test1.hii();
        // test1.hey();     // why this didn't work? -> reason in below line
        MyInterface.hey();  // Interface static methods belong only to the interface that declares them, neither sub-interface nor class implementing interface inherits the static method.


        Child ch = () -> System.out.println("Hello from Child");
        ch.sayHello();
        ch.hii();
        Child.hey(); // Unlike Class, Interface static methods are not inherited by subinterfaces.
                                   // &  class implementing interface doesn't inherit static methods either.
        Class1 c1 = new Class1();
        c1.sayHello();
        // c1.hey();         // class implementing interface doesn't inherit static methods either.

        // MOST IMPORTANT POINT TO REMEMBER: Java wants a static method to belong to the interface itself, not to objects, sub-interfaces and not to implementing classes.




        // STATIC KEYWORD - FINAL CONCLUSION

        // 1. Static members belong to the class/interface itself, not to objects.

        // 2. Static methods:
        //    - can be called using ClassName.method()
        //    - directly access only static members
        //    - cannot use this or super
        //    - do not participate in runtime polymorphism

        // 3. Instance methods:
        //    - belong to objects
        //    - can access both instance and static members
        //    - can be overridden

        // 4. Class inheritance:
        //    - static methods are inherited
        //    - static methods are hidden, not overridden

        // 5. Interface inheritance:
        //    - static methods are NOT inherited by subinterfaces
        //    - static methods are NOT inherited by implementing classes
        //    - therefore interface static methods are neither hidden nor overridden

        // 6. Default interface methods are instance methods.
        //    They are inherited and can be overridden.
    }
}
