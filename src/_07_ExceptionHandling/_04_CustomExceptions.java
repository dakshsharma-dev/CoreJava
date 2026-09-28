package _07_ExceptionHandling;

//exception class created by the programmer to represent application-specific or business-specific error scenarios.
//
//Examples of User-defined Exception:
//Invalid bank transaction
//Insufficient balance
//Age not eligible for registration
//Invalid login attempt

//Why use a custom exception instead of simply returning an error message?
//A custom exception represents a specific type of failure, allowing it to PROPAGATE through different layers and be handled differently. A returned message is just data and DOESN'T CARRY that SEMANTIC meaning.


// TYPES:
// 1. Custom checked exception:
//    Extends Exception.
//    If it is thrown from a method, it must be either handled with try-catch
//    or declared in the method's throws clause.

// 2. Custom unchecked exception:
//    Extends RuntimeException.
//    It is not checked by the compiler, so it does not need to be
//    handled or declared with throws.




// *************IMPORTANT NOTE:  Custom Exception — Why super(message) is used?
//
// When creating a custom exception:
// e.g.
// class InvalidAgeException extends Exception {
//     InvalidAgeException(String message) {
//         super(message);
//     }
// }
//
// InvalidAgeException extends Exception, so it inherits the functionality that Exception already provides.
//
// The Exception class already has:
// a constructor that accepts a message
// getMessage() to retrieve that message
// internal handling/storage of the message
//
// So when we write: super(message);
//
// we pass our custom message to the parent Exception class and reuse its existing functionality.
// Therefore, we don't need to write our own message storage, constructor logic, getMessage() method, etc. for every custom exception.
//
// Flow:
//
// Our custom message
// ↓
// super(message)
// ↓
// Exception's constructor
// ↓
// Exception handles/stores the message
// ↓
// getMessage() can retrieve it
//
// Core idea:
// Custom exceptions extend Exception so they can reuse the functionality already provided by the parent class, while adding their own specific exception type/meaning.


// For a user-defined exception:
// extends Exception → Checked → must be handled (try-catch) or declared (throws)
// extends RuntimeException → Unchecked → compiler does not force handling/declaration


// Checked Custom Exception
class InvalidAgeException extends Exception{                // InvalidAgeException is your custom exception. & extends Exception → checked exception.
    public InvalidAgeException(String message){             // constructors with custom messages
        super(message);                                     // passes the message to the parent Exception class. [MORE DETAILED REASON WRITTEN ABOVE THIS CLASS IN THEORY]
    }
}

// Unchecked custom Exception
class DivideByZeroException extends RuntimeException{
    public DivideByZeroException(String message){
        super(message);
    }
}

public class _04_CustomExceptions {
    static void checkAge(int age) throws InvalidAgeException{
        if(age < 18){
            throw new InvalidAgeException("Age must be at least 18");
        }
        System.out.println("Valid Age: " + age);
    }

    static void divide(int a, int b){
        if(b == 0){
            throw new DivideByZeroException("Denominator can't be zero");
        }
        System.out.println("Result: " + a / b);
    }

    public static void main(String[] args) {
        //checkAge(15);             // compiler force handling as this is checked exception
        try{
            checkAge(15);
        }
        catch(InvalidAgeException e){
            System.out.println("Exception Caught: " + e.getMessage());
        }

        // divide(5, 0);           // compiler does not force handling as unchecked exception
        try{
            divide(5, 0);
        }
        catch(DivideByZeroException e){
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
