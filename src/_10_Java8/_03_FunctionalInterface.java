package _10_Java8;

/*
    1. Inheritance in Functional Interface

    @FunctinalInterface      // restricts the interface to be a functional interface -> will throw compile-time error if try to add another abstract method
    interface A{
        void sayHello();
    }

    Case1:
    @FunctionalInterface
    interface B extends A{}

    Case2: Note a functional interface
    @FunctionalInterface    // error
    interface C extends A{
        void sayBye();
    }

    Case3:
    @FunctionalInterface
    interface D extends A{
        void sayHello();
    }

    Case4:
    @FunctionalInterface
    interface E extends A{
        void sayHello();

        default void show(){.....}
        static void show(){.....}
    }


    2.
    Instance method:
        → belongs to an object (non-static)

    Concrete method:
        → has an implementation/body


    3.
    Java8 introduced: concrete methods(static and default)


    4.
    Default interface methods are concrete instance methods. `default` is NOT an access modifier and has nothing to do with package-private (no modifier)
    They are inherited and can be overridden.


    5.
    There is no restriction on the NUMBER OF default or static methods.

*/



@FunctionalInterface
interface MyInterface{
    void sayHello();

    default void hii() {System.out.println("Hii from Parent");}

    static void hey() {System.out.println("Hey from Parent");}
}


@FunctionalInterface
interface Child extends MyInterface{
    @Override
    default void hii(){
        System.out.println("Hii from Child interface");
    }

    // @Override // static methods can't be overridden
    // Same name, same signature as parent but no overriding, no hiding, no inheritance relationship. They just happen to have the same name(they are independent methods)
    static void hey(){
        System.out.println("Hey from Child interface");
    }
}


class Class1 implements MyInterface, Child{
    public void sayHello(){
        System.out.println("hello ji!!");
    }
    // Interface methods are implicitly public abstract. Therefore, the implementing method must also be public.
}




// AN INTERVIEW POINT:
interface A{
    default void sayBye(){
        System.out.println("Hello from A");
    }
}
interface B{
    default void sayBye(){
        System.out.println("Hello from B");
    }
}
//class Class2 implements A, B{}

// sayBye() has same signature in both A and B -> conflict as Class2 has two equally valid default implementations to inherit.
// what to do?
// 1. if B were child of A, then no conflict as Class2 will either inherit B's overridden sayBye() or A's sayBye() through B if B doesn't override it
// 2. Override/implement sayBye() in Class2

class Class2 implements A, B{
    @Override
    public void sayBye(){
        A.super.sayBye();
        // or
        // B.super.sayBye();
        // or
        // sout(....);
    }
}




public class _03_FunctionalInterface {
    public static void main(String[] args) {
        // implementing functional interface via anonymous inner class
        MyInterface test = new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("Hello from Parent(anonymous inner class)");
            }
        };
        test.sayHello();


        // using lambda expression instead of anonymous inner class
        MyInterface test1 = () -> System.out.println("Hello from Parent(lambda expression)");
        test1.sayHello();
        test1.hii();
        // test1.hey();     // Interface static methods can only be called via interfaceName.
        MyInterface.hey();  // Interface static methods belong only to the interface that declares them only, neither sub-interface nor class implementing interface inherits the static method.


        Child ch = () -> System.out.println("Hello from Child");
        ch.sayHello();
        ch.hii();
        Child.hey();                  // This is Child's own static method not inherited from MyInterface // Unlike Class, Interface static methods are not inherited by subinterfaces  &  implementing class

        MyInterface c1 = new Class1();
        c1.sayHello();
        c1.hii();
        // Class1.hey();              // class implementing interface doesn't inherit static methods either.

        // MOST IMPORTANT POINT TO REMEMBER: Java wants a static method to belong to the interface itself, not to objects, sub-interfaces and not to implementing classes.


    }
}
