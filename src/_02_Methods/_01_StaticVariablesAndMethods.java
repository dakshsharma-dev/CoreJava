package _02_Methods;

/*
    Instance members -> belong to objects
    Static members   -> belong to the **CLASS** and are **SHARED BY ALL OBJECTS** -> Therefore, static methods don't participate in runtime polymorphism & Memory is allocated only once when the class is loaded

    Static methods can DIRECTLY access only static members. & static methods can't use this or super keywords.[because a static method has no object]
    Instance methods can access both instance and static members.
*/
class Mobile{
    // instance variables
    String brand;
    int price;
    // static variable
    static String name;


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




// inheritance of static methods in CLASS
class A {
    static void show() {
        System.out.println("in A show");
    }
}
class B extends A {
    // @Override  // static methods are inherited but can't be overridden
    static void show() {                  // hides the parent's method not override
        System.out.println("in B show");
    }           // This is method hiding
    // Override → child replaces parent's instance method behavior at runtime.
    // Hide → child creates its own static method -> meaning: **CHILD HAS ITS OWN STATIC METHOD & PARENT HAS ITS OWN STATIC METHOD**(its just a coincidence that they both have the same name and signature)
}
class C extends A{

}





// Inheritance of static methods in INTERFACE
interface MyInterface{
    // static void show();                  // Error, as static methods has to have some body in interface
    static void show(){
        System.out.println("in MyInterface show");
    }
}
interface MyInterface2 extends MyInterface{
    // Java treats interface static methods as belonging specifically to that interface, not as methods that gets passed down to its subinterfaces/implementing classes.
    // doesn't inherit static methods of parent, but we can DEFINE same signature using its own implementation

    // This is MyInterface2's own static method not inherited from MyInterface
    static void show(){ System.out.println("in MyInterface2 show");}
}
class MyInterfaceImplementation implements MyInterface{
    // class doesn't inherit static methods of parent but can DEFINE same signature method using its own implementation
    static void show(){
        System.out.println("in MyInterfaceImplementation show");
    }
}

/*
    1. Class inheritance:
       - static methods are inherited
       - static methods are hidden, not overridden
    2. Interface inheritance:
       - static methods are NOT inherited by subinterfaces
       - static methods are NOT inherited by implementing classes
       - therefore interface static methods are neither hidden nor overridden
*/


public class _01_StaticVariablesAndMethods {
    public static void main(String[] args){   // main() is static so the JVM can call it without creating an object of _01_StaticVariablesAndMethods
        Mobile obj1 = new Mobile();
        obj1.brand = "Apple";
        obj1.price = 1500;
        // obj1.name = "SmartPhone";   // not ideal way to call a static variable
        Mobile.name = "SmartPhone";    // access static members using the class name (recommended)


        Mobile obj2 = new Mobile();
        obj2.brand = "Samsung";
        obj2.price = 1500;
        Mobile.name = "SmartPhone" ;
        Mobile.name = "Phone";          // just an idea: this will make obj1.name = "Phone" as well as obj2.name = "Phone" also as name is a static variable in class Mobile & *****static variable is shared by all the objects*****

        obj1.show();         // instance methods are called through objects
        obj2.show();

        // Mobile.show();   // can't make a static reference to a nonstatic method
        Mobile.show1();     // static method {direct access of instance variable denied}
        Mobile.show1(obj1); // static method {indirect access of instance variables}




        // INHERITANCE OF STATIC METHODS in CLASSES
        System.out.println("Inheritance(static methods): ");

        A.show();            // in A show
        B.show();            // in B show  // B.show() hides A.show() when you access the method through class B.
        C.show();            // in A show  // static methods are inherited in classes


        // Static methods are resolved using the reference type.[*********Because static methods are associated with the class, not the object.*********]
        // That's why the preferred way of calling static methods is via className not object
        // Instance methods are resolved using the actual object type.
        A Aobj = new B();
        Aobj.show();         // in A show




        // Inheritance of static methods in INTERFACE
        MyInterface.show();
        MyInterface2.show();                                   // interface static methods are not inherited in sub-interface
        MyInterfaceImplementation.show();                      // interface static methods are not inherited in implementing class
    }
}

