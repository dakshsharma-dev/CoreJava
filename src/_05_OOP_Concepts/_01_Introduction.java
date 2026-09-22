package _05_OOP_Concepts;

public class _01_Introduction {
    public static void main(String[] args) {
//         Rules to remember about constructors:
//
//         does not have any return type, not even void.
//         No constructor written → Java creates a default no-arg constructor.
//         At least one constructor written → Java does not create the default constructor.
//         Constructor call must match an existing constructor, otherwise compilation fails.

//        Types of constructors:
//        1. default       -> does not accept any parameters and initializes an object with default values.
//        2. parameterized -> accepts parameters to initialize an object with specific values.
//        3. private       -> declared with the private access modifier that prevents object creation from outside the class.
//                              Used in patterns like Singleton or utility classes containing only static methods.

//        4. copy          -> user-defined constructor that creates a new object by copying the data of another object of the same class.
//        e.g.
//        /*
//            class Student {
//                String name;
//
//                Student(Student other) {
//                    this.name = other.name;
//                }
//            }
//            Student s1 = new Student();
//            s1.name = "Daksh";
//
//            Student s2 = new Student(s1); // copy constructor
//        */
//
    }
}
