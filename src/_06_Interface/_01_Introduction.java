package _06_Interface;

//is a constract/blueprint that defines a set of methods a class must implement



// class     - class         -> extends
// class     - interface     -> implements
// interface - interface     -> extends








// abstract class tempClass{                          // abstract class with only abstract methods ----------> interface comes into picture
//     public abstract void show();
//     public abstract void config();
// }

interface tempClass0{                                 // just gives the design(gives the methods which you have to implement yourself)    // interfaces don't have their own memory in heap
    int age = 21;                                     // final and static by default(because for interface you can only implement methods in other classes not variables)
    String name = "Daksh";

    void show();                                      // every method in interface is public abstract by default(no need to name them explicitely public abstract though if you do so no error will be thrown)
    void config();
}

abstract class tClassA implements tempClass0{         // if you don't define all the methods of interface then you have to make this class abstract
    public void show(){
        System.out.println("in show");
    }
    // public void config(){
    //     System.out.println("in config");
    // }
}

class tClassB extends tClassA{
    public void config(){
        System.out.println("in config");
    }
}






// NEXT to NEXT LECTURE (MULTIPLE INTERFACES)
interface tempClass1{
    void run();
}
interface tempClass2 extends tempClass1{                    // INHERITENCE in case of interfaces
    // YOU WILL GET       void run();         HERE TOO AS OBEYING INHERITENCE

}

class tClassC implements tempClass0, tempClass1{            // we can have one class implementing MULTIPLE INTERFACES         **unlike**          ABSTRACT CLASS WHERE ONE CLASS CAN ONLY EXTEND ONE ABSTRACT CLASS
    public void show(){
        System.out.println("in show");
    }
    public void config(){
        System.out.println("in config");
    }
    public void run(){
        System.out.println("in run");
    }
}
public class _01_Introduction {
    public static void main(String[] args) {
        tempClass0 obj;                              // there is no problem in creating a reference of interface
        // obj = new tempClass();                    // can't instanciate a interface

        obj = new tClassC();
        obj.show();
        obj.config();
        // obj.run();                               // .run() is undefined for tempClass0 which is the REFERENCE

        tempClass1 obj1 = new tClassC();
        obj1.run();                                 // .run() is defined for tempClass1 which is the REFERENCE here



        // tempClass2 obj2 = new tClassC();         // will give error as tClassC doesn't implement tempClass2          instead       tClassC only implements tempClass0, tempClass1




        System.out.println(tempClass0.age);         // can call directly as these are static variable
        System.out.println(tempClass0.name);
        // tempClass0.name = "Sneha";               // final field can't be updated
    }
}
