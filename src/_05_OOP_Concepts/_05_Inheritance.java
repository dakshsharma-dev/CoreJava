package _05_OOP_Concepts;

//Methods → can be overridden (runtime polymorphism).
//Fields → are inherited, but they are hidden, not overridden.

//For methods, Java chooses based on the actual object (Dog).
//For fields, Java chooses based on the reference type (Animal).

//Reference type determines:
//        - which fields can be accessed
//        - which methods can be called
//
//Actual object determines:
//        - which overridden method implementation runs

//Private members are not accessible in subclasses.
//protected allows subclasses to access a member directly, while private does not.

class Animal{
    String name = "Animal";
    public void sound(){
        System.out.println("Makes Sound");
    }
}
class Dog extends Animal{
    String name = "Dog";                                   // hides Animal's name  // Now Dog has its own name field and also inherits the parent's field.
    String speed = "medium-fast";                          // can add its own field and functionality
    public void sound(){
        System.out.println("Dog Makes barking sound");
    }
    public void run(){
        System.out.println("Dog running....");
    }
}
class Cat extends Animal{
    String name = "Cat";                                  // hides Animal's name
    public void sound(){
        System.out.println("Cat Makes meowing sound");
    }
}
public class _05_Inheritance {
    public static void main(String[] args) {
        // Animal Reference
        Animal an;
        an = new Dog();
        System.out.println(an.name);         // Animal (Fields are resolved based on the reference type)
        an.sound();
//        System.out.println(an.speed);      // Error as Animal class doesn't have a field named speed -> compilation fails. [fields and methods that can be called are checked using the reference type at compile time.]
//        an.run();                          // Error as Animal class doesn't have a run() method      -> compilation fails. [fields and methods that can be called are checked using the reference type at compile time.]
        System.out.println();

        an = new Cat();
        System.out.println(an.name);         // Animal
        an.sound();
        System.out.println();


        // Dog Reference
        Dog dg = new Dog();
        System.out.println(dg.name);         // Dog (Fields are resolved based on the reference type)
        System.out.println(dg.speed);
        dg.sound();
        dg.run();
    }
}

//TYPES OF INHERITANCE:
  // 1. Single Inheritance: One child inherits from one parent.
  // 2. Multilevel Inheritance: Inheritance chain.
        /*
            class Animal {}
            class Dog extends Animal {}
            class Puppy extends Dog {}
        */
  // 3. Hierarchical Inheritance: Multiple children inherit from the same parent.
        /*
            class Animal {}
            class Dog extends Animal {}
            class Cat extends Animal {}
        */
  // 4. Multiple Inheritance: A class inheriting from multiple classes.
        // Note: Java does not allow this with classes.
        // Note: Java supports multiple inheritance through interfaces, not classes.
        // class C extends A, B {}      // illegal
        // class C implements A, B {}   // legal

  // 5. Hybrid Inheritance: combination of two or more types of inheritance, such as multilevel + hierarchical, and in Java it can also involve interfaces for multiple inheritance.
        /*
            class Animal {}
            class Dog extends Animal {}
            class Cat extends Animal {}

            interface Pet {
                void play();
            }

            class Puppy extends Dog implements Pet {
                public void play() {}
            }
        */



