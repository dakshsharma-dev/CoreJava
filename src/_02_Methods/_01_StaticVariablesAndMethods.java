package _02_Methods;

/*
    Instance members -> belong to objects
    Static members   -> belong to the class and are shared by all objects & Memory is allocated only once when the class is loaded

    Static methods can directly access only static members. & static methods can't use this or super keywords.[because a static method has no object]
    Instance methods can access both instance and static members.
*/
class Mobile{
    String brand;
    int price;
    // above variables are called instance variables
    static String name;  // belongs to the class and is shared by all objects


    public void show(){  // instance method
        // variable created inside a method is called local variable
        System.out.println(brand + ": " + price + ": " + name); // in non-static methods, one can use static variables without any issue
    }


    public static void show1(){
        System.out.println("In static method");
        // System.out.println(brand + ": " + price + ": " + name); // can use static variable inside a static method but not instance variable

        // because brand and price are diff for diff objects so show1() won't know which one are you referring to

        // so **DIRECT** access of non-static variables is not allowed in static methods {for indirect access just pass the object to which you are referring}
        // static methods can't use this or super keywords
    }


    // making the method such that instance variables can be used via indirect access
    public static void show1(Mobile obj){
        System.out.println(obj.brand + ": " + obj.price + ": " + name);
    }
}


public class _01_StaticVariablesAndMethods {
    public static void main(String[] args){   // main() is static so the JVM can call it without creating an object

        Mobile obj1 = new Mobile();
        obj1.brand = "Apple";
        obj1.price = 1500;
        // obj1.name = "SmartPhone";   // not ideal way to call a static variable
        Mobile.name = "SmartPhone";    // access static members using the class name (recommended)


        Mobile obj2 = new Mobile();
        obj2.brand = "Samsung";
        obj2.price = 1500;
        Mobile.name = "SmartPhone" ;

        Mobile.name = "Phone"; // this will make obj1.name = "Phone" as well as obj2.name = "Phone" also as name is a static variable in class Mobile & *****static variable is shared by all the objects*****



        obj1.show();         // instance methods are called through objects
        obj2.show();

        // Mobile.show();   // can't make a static reference to a nonstatic method
        Mobile.show1();     // static method {direct access of instance variable denied}
        Mobile.show1(obj1); // static method {indirect access of instance variables}
    }
}

/*  INHERITANCE IN CLASSES
    LEARNING: Static methods are not overridden; they are hidden.

    class A {
        static void show() {
            System.out.println("A");
        }
    }

    class B extends A {
        static void show() {
            System.out.println("B");
        }
    }

    A obj = new B();
    obj.show();   // Output: A

    Why?
    - Instance methods are resolved using the actual object type.
    - Static methods are resolved using the reference type.[*********Because static methods are associated with the class, not the object.*********]
    That's why the preferred way of calling static methods is via className not object

    Therefore:
    - Static methods do not participate in runtime polymorphism.
    - If a subclass defines a static method with the same signature, it hides the parent's method rather than overriding it.

    So:
        A.show();  // A
        B.show();  // B  // B.show() hides A.show() when you access the method through class B.

    Both methods exist independently.


    INSTANCE METHOD
            ↓
    belongs to object
            ↓
    runtime object matters
            ↓
    overriding
            ↓
    runtime polymorphism


    STATIC METHOD
            ↓
    belongs to class
            ↓
    class/reference type matters
            ↓
    hiding
            ↓
    no runtime polymorphism


    Override → child replaces parent's instance method behavior at runtime.
    Hide → child creates its own static method; parent's static method still exists separately.
*/


/*  INHERITANCE IN INTERFACE
    Look file lambdaExpressionsAndFunctionalInterface


    CONCLUSION:
    Class static method → inherited by child → can be hidden.
    Interface static method → not inherited by subinterfaces or implementing classes.
    Static methods → not method overriding but method hiding
    Instance methods → belong to objects → can be overridden.
*/

