package _07_ExceptionHandling;
// Exceptions are events that interrupt the normal flow of program execution.
// NEED OF EXCEPTION HANDLING: Exceptions handling prevent the program from terminating unexpectedly and allows developers to provide appropriate recovery or error-handling logic.


// Exception Hierarchy
//Object
//└── Throwable
//    ├── Error
//    │   └── generally unchecked
//    │
//    └── Exception
//        ├── RuntimeException
//        │   └── Unchecked
//        │
//        └── Other Exceptions****(OTHER not just compile-time)
//            └── Checked


// Types of Exceptions:
// 1. Built-in
// 2. User-defined

// Both built-in and user-defined exceptions can be:

// 1. Checked:   checked at compile time, so the programmer must handle them explicitly or declare them using `throws`.
//               Commonly represents conditions such as file or database failures.
//               MUST BE either HANDLED using a try-catch block or declared using the throws keyword.

// 2. Unchecked: checked at runtime, so the programmer is not required to handle them explicitly at compile time.
//               Commonly results from programming mistakes, such as accessing an invalid array index, using a null object reference, or dividing by zero.
//               CAN BE handled using a try-catch block or declared using the throws keyword.


//Why does the compiler force handling/declaration of checked exceptions?
//Because they represent recoverable situations that a program should handle
//The compiler wants to ensure you have considered:
//What if the file doesn't exist?
//What if the disk fails?
//What if the database connection is lost?

//Why doesn't the compiler force unchecked exceptions?
//Because they usually represent programming mistakes that should be fixed, not handled.


public class _01_Introduction {
    public static void main(String[] args) {

    }
}
