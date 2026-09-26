package _06_Interface;

//is a contract/blueprint that defines a set of methods a class must implement
// Use an interface when you need to define a contract for behavior that multiple classes can implement.

// class     - interface     -> implements
// interface - interface     -> extends
// class     - class         -> extends

// IMPORTANT
//Class → extends → one class
//Class → implements → multiple interfaces
//Interface → extends → multiple interfaces


// abstract class tempClass{                          // abstract class with only abstract methods ----------> interface comes into picture
//     public abstract void show();
//     public abstract void config();
// }


interface interface0 {                                // just gives the design(gives the methods which you have to implement yourself)    // interfaces don't have their own memory in heap
    int age = 21;                                     // Interface variables are implicitly public static final (constants).
    String name = "Daksh";

    void show();                                      // every method is public abstract by default(no need to name them explicitly public abstract though if you do so no error will be thrown)
    void config();
}

abstract class tClassA implements interface0 {         // if you don't define all the methods of interface then you have to declare the class as abstract
    public void show() {
        System.out.println("in show of tclassA");
    }
    // public void config(){
    //     System.out.println("in config");
    // }
}

class tClassB extends tClassA {
    public void config() {
        System.out.println("in config of tclassB");
    }
}




// MULTIPLE INHERITANCE USING INTERFACE
interface interface1 {
    void run();
}

interface interface2 extends interface1 {                    // INHERITANCE in case of interfaces
    // YOU WILL GET       void run();                           HERE TOO AS OBEYING INHERITANCE

}

class tClassC implements interface0, interface1 {            // A class can extend only one class (abstract or non-abstract), but can implement multiple interfaces.
    public void show() {
        System.out.println("in show of tclassC");
    }

    public void config() {
        System.out.println("in config of tclassC");
    }

    public void run() {
        System.out.println("in run of tclassC");
    }
}

public class _01_Introduction {
    public static void main(String[] args) {
        interface0 obj;                              // there is no problem in creating a reference of interface
        // obj = new interface0();                   // can't create an instance of an interface

        obj = new tClassC();
        obj.show();
        obj.config();
        // obj.run();                               // .run() is undefined for interface0 which is the REFERENCE[& reference decides which variables and methods can be accessed]

        // to implement all 3 methods at once, create the reference itself of type tClassC ,but we created reference of interface0 so that it can be later assigned to some other class implementing interface0 without creating a new reference -> concept of loose coupling & when reference is of type tClassC -> tight coupling


        interface1 obj1 = new tClassC();
        obj1.run();                                 // .run() is defined for interface1 which is the REFERENCE here


        // interface2 obj2 = new tClassC();         // will give error as tClassC doesn't implement interface2          instead       tClassC only implements interface0, interface1


        System.out.println("Age of interface0: " + interface0.age);         // can call directly as these are static variable
        System.out.println("Name of interface0: " + interface0.name);
        // interface0.name = "Sneha";               // final field can't be updated
    }
}
