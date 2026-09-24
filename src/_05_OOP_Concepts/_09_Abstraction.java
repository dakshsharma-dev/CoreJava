package _05_OOP_Concepts;
//Abstraction means exposing only the necessary functionality while hiding implementation details.
//achieves abstraction through Abstract classes & Interfaces

public class _09_Abstraction {
    public static void main(String[] args) {

    }
}

/* How abstraction is achieved?
    Example:
    interface Flyable {
        void fly();
    }

    class Bird implements Flyable {
        public void fly() {
            System.out.println("Flying");
        }
    }

    main(){
        Flyable f = new Bird();
        f.fly();
    }

    The user/code using f only knows: This object can fly().

    They don't need to know: How does Bird.fly() actually make it fly?
    That implementation is hidden inside Bird.
    So abstraction is essentially: Expose WHAT can be done → hide HOW it is done.

    Abstraction is possible when you separate what an object can do from how it does it.
    Interface / abstract class → defines WHAT
    Concrete class → defines HOW
    User interacts with the WHAT, without needing to know the HOW.
*/
