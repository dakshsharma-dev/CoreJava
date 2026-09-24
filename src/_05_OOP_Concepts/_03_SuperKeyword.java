package _05_OOP_Concepts;
// POINTS TO REMEMBER ABOUT this() & super()
// this(...) → calls another constructor of the same class.
//         super(...) → calls a constructor of the parent class.
// Both must be the first statement of a constructor.
// A constructor can call either this(...) or super(...) directly, not both.
// If neither is written, Java automatically inserts super().
// Automatic super() works only if the parent has an accessible no-argument constructor else shows compilation error.
//         this(...) can call a parameterised or no-arg constructor, and vice versa.
// Constructor chaining must eventually reach super(...); cyclic this(...) calls are illegal.
// this (without (...)) refers to the current object; super (without (...)) refers to the parent part of the current object.




// IDEA of super(): Child object = Parent part + Child part
// so super lets you access the Parent part of the current object.

//        Access Parent Class Variable
class Parent{
    int x = 10;
}
class Child extends Parent{
    int x = 20;
    void display(){
        System.out.println(x);       // child'x
        System.out.println(super.x); // parent'x
    }
}


//        Call Parent Class Method
class Father{
    void display() {
        System.out.println("father display");
    }
}
class Son extends Father{
    @Override
    void display(){
        System.out.println("son display");
    }
    void showBoth(){
        display();
        super.display();
    }
}


//       Call Parent Class Constructor
class Mother{
    Mother(){
        System.out.println("Mother constructor");
    }
}
class Daughter extends Mother{
    Daughter(){
//        super();                                   // Even if you don't write super(), Java inserts it automatically if its valid(if the parent class has an accessible no-argument constructor.)
        System.out.println("Daughter constructor");
    }
    Daughter(int x){
        this();
        System.out.println("parameterized constructor of Daughter");
    }
}
public class _03_SuperKeyword {
    public static void main(String[] args) {
        Child chh = new Child();
        chh.display();

        Son sn = new Son();
        sn.showBoth();

        Daughter dr = new Daughter(5);
        // OUTPUT:
//        Mother constructor
//        Daughter constructor
//        parameterized constructor of Daughter
//        new Daughter(5) → Daughter(int) calls this() → Daughter() automatically calls *****super()***** → Mother() runs first, then control returns to Daughter() and finally Daughter(int).
    }
}

