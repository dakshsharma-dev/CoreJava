package _05_OOP_Concepts;

// allows the same method to exhibit different behaviors.
// achieved through method overloading and method overriding.

// TYPES:
// 1. Compile-time/Static Polymorphism:
    // method to be executed is determined during compilation.
    // achieved through method overloading.

    // Method Overloading: same name but different parameter lists
    // NOTE: Changing only return type doesn't create overloading.
    // parameters can differ in:
        //Number of parameters
        //Data types of parameters
        //Order of parameters


// 2. Runtime/Dynamic Polymorphism:
    // method call is resolved during program execution.
    // achieved through method overriding.

    // Method Overriding: subclass provides its own implementation of a method already defined in its superclass
    // overridden method is selected based on the actual object created.


// POINTS TO REMEMBER:
// 1. private methods aren't inherited and therefore cannot be overridden.
// 2. static  methods aren't overridden; they are hidden.
// 3. final methods cannot be overridden.
// 4. Constructors cannot be overridden.


/*  1. private methods aren't inherited and therefore cannot be overridden.
    class Animal {
        private void sound() {
        }
    }

    class Dog extends Animal {
        void sound() {
        }
    }

    Dog cannot access Animal.sound() because it's private.
    So Dog.sound() is simply a new, unrelated method.
*/


/*  2. static  methods aren't overridden; they are hidden.
    class Animal {
        static void sound() {
            System.out.println("Animal");
        }
    }

    class Dog extends Animal {
        static void sound() {
            System.out.println("Dog");
        }
    }

    This is called method hiding, not overriding.
    For an overridden instance method, Java looks at the actual object.
    For a static method, it doesn't use runtime polymorphism like that; the method is associated with the class/REFERENCE type.
*/


/*  3. final methods cannot be overridden.
    class Animal {
        final void sound() {
            System.out.println("Animal");
        }
    }

    class Dog extends Animal {
        // ❌ Cannot override final method
        void sound() {
        }
    }

    final means: This method's implementation cannot be replaced by a subclass.
*/


/*  4. Constructors cannot be overridden.
    class Animal {
        Animal() {}
    }

    class Dog extends Animal {
        Dog() {}
    }

    Dog() is not overriding Animal().
    It's simply Dog's own constructor.
*/


/*  Importance of @Override:
    class A{
        void doThis(){
            System.out.println("done");
        }
    }
    class B extends A{
        @Override                             // I intend this method to override a method inherited from the parent.
        void doTis(){                         // Here, we accidentally forget to write 'h' in the method name, but the compiler will interpret it as a new method rather than an overridden method BUT @Override annotation prevents that, saying you intended to override this method but has not, So check for the mistake you have made
            System.out.println("to be done");
        }
    }
*/


public class _06_Polymorphism {
    public static void main(String[] args) {

    }
}
