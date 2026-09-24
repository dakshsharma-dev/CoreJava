package _05_OOP_Concepts;

// class defined inside another class
// NOTE: inner class has access to all members (including private) of the outer class, but the outer class can access the inner class members only through an object of the inner class.

// TYPES:
// 1. STATIC NESTED CLASS                       2. NON-STATIC NESTED CLASS
//                                              a). Member Inner Class
//                                              b). Method-Local Inner Class
//                                              c). Anonymous Inner Class




//1. STATIC NESTED CLASS(IMPORTANT *****)
// does not have access to instance members of the outer class but can access static members.
class Outer1 {
    private static int num = 10;

    static class Inner1 {
        public void display() {
            System.out.println("Num is: " + num);
        }
    }
}
// Inner1 is declared static, so it belongs to the class Outer1 itself, not to an Outer1 object.[i.e. Inner class is static and static members of a class can be called by just their className without creating a object]
// That's why you create it like:
// Outer1.Inner1 in1 = new Outer1.Inner1();   -> without creating an Outer1 object.
// Since no Outer1 object exists, Inner1 cannot access instance variables of Outer1, but can only access static ones.




//2. Member Inner Class(RARELY USED****)
// member inner class is a non-static class defined at the member level of another class.
// access to all members of the outer class, including private members.

class Outer2{
    private int num = 20;

    class Inner2{
        public void display(){
            System.out.println("Num is: " + num);
        }
    }
}
//Every Inner2 object is attached to an Outer2 object.
//That's why:
//Outer2.Inner2 in2 = new Outer2().new Inner2();
//First create: new Outer2()
//then create an Inner2 belonging to that specific Outer2.




// 3. Method-Local Inner Class(RARELY USED****)
// method-local inner class is defined inside a method of the outer class.
// can only be instantiated within the method where it is defined.
class Outer3 {
    void outerMethod() {
        System.out.println("Inside outerMethod");

        // Method-local inner class
        class Inner3 {
            void innerMethod() {
                System.out.println("Inside innerMethod");
            }
        }

        Inner3 inner = new Inner3();
        inner.innerMethod();
    }
}
// This class(Inner3) exists only to help that one method.
// Java doesn't even know Inner3 exists.




// 4. Anonymous Inner Classes(IMPORTANT *****) : create a subclass/object right here, right now, for one-time use.
// anonymous inner class is an inner class without a name.
// Declared and instantiated in one statement.
// Used for one-time use implementations.
// Cannot have constructors (since it has no name).
// Commonly used in event handling and functional programming.

// 4a) As a Subclass
class Demo{
    void show(){
        System.out.println("Inside Demo's show method");
    }
}
// 4b) As an Interface Implementation
interface Hello{
    void greet();
}


public class _08_InnerClass {
    public static void main(String[] args) {
        // IMPORTANT
        Outer1.Inner1 in1 = new Outer1.Inner1();
        in1.display();

        // RARELY USED
        Outer2.Inner2 in2 = new Outer2().new Inner2();
        in2.display();

        // RARELY USED
        Outer3 outer3 = new Outer3();
        outer3.outerMethod();


        // IMPORTANT
        // what if I want to change the behavior of show() method?
        // 1st approach) method overriding extending Abc class by another class BUT the only purpose of new class will be to override the previous method and will be used only once so there is no point in creating a total new class.
        // 2nd approach) anonymous inner class

        // 4a) Anonymous inner class extending Demo
        Demo demo = new Demo(){
            @Override
            public void show(){
                System.out.println("Inside anonymous class");
            }
        };     // you're not just defining a class; you're creating an object & object creation ends with ;
        demo.show();
        // Java creates a subclass of Demo, but you never give it a name, so it's called an anonymous class.

        // 4b) Anonymous inner class implementing Hello
        Hello hello = new Hello(){
            @Override
            public void greet(){
                System.out.println("Hello from anonymous class");
            }
        };
        hello.greet();
    }
}
