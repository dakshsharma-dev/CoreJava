package _05_OOP_Concepts;

abstract class Car{                   // abstract class  // Only an abstract class can declare an abstract method.
    public abstract void drive();     // abstract method // abstract means just idea(here - declaration) not implementation
    public abstract void fly();
    public void playMusic(){          // concrete method
        System.out.println("Playing music....");
    }   // concrete method
}

abstract class BMW extends Car{        // Abstract because: A concrete subclass must implement all inherited abstract methods, otherwise it must also be declared abstract.
    public void drive(){
        System.out.println("Driving....");
    }

}

class RollsRoyce extends BMW{          // concrete class // A concrete subclass must implement all inherited abstract methods, otherwise it must also be declared abstract.
    public void fly(){
        System.out.println("Flying....");
    }
}


// IMPORTANT NOTE: 1 class can only extend 1 abstract class

public class _07_AbstractKeyword {
    public static void main(String[] args) {
        // Car obj = new Car();        // one can't create object of abstract class as abstract class is incomplete by design[Abstract class can't be instantiated]
        // Car obj = new BMW();        // SAME REASON
        Car obj = new RollsRoyce();    // An abstract-class reference can refer to an object of any concrete subclass, basically runtime polymorphism
        obj.drive();
        obj.playMusic();
        obj.fly();
    }
}


// points to remember:
//1. A class can be declared abstract even when it does not contain any abstract method. Such a class CAN'T be instantiated directly but can be inherited by other classes.

