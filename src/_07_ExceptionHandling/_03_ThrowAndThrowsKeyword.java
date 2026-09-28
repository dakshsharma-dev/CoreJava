package _07_ExceptionHandling;

// throw is used to explicitly throw an exception.

// throws is used to declare exceptions in a method signature.
// Declare that this method may throw one of the listed exceptions, and I'm not handling it here. The caller is responsible for handling it

public class _03_ThrowAndThrowsKeyword {
    static void fun(){
        try{
            throw new NullPointerException("demo");                    // create + throw a new exception
            // System.out.println("fun catch completed");              // unreachable statement
        }
        catch(NullPointerException e){
            System.out.println("Exception caught, inside fun: " + e);
            throw e;                                                   // rethrow existing exception
            // System.out.println("fun catch completed");              // unreachable statement
        }
    }


    static void threadRun() throws InterruptedException{
        Thread.sleep(10);
        System.out.println("Hello from thread function");
    }
    // Declares that threadRun() may throw InterruptedException.
    // In this execution, Thread.sleep() does not throw it.


    static void fun1() throws IllegalAccessException{
        System.out.println("Inside fun1");
        throw new IllegalAccessException("demo1");
    }
    // fun1() doesn't handle the exception, so it propagates to the caller.

    public static void main(String[] args) {
        // use of throw
        try{
            fun(); // *******Static methods can be called using the class name, but the class name is optional when you're already in the same class.
                   // *******class name is mandatory when you are calling static method from another class.
        }
        catch(NullPointerException e){
            System.out.println("Exception caught, inside main: " + e);
        }

        // use of throws
        try{
            threadRun();
            // throws does NOT throw an exception by itself.
            // It only declares that the method may throw the specified exception.
        }
        catch(InterruptedException e){
            System.out.println("Exception caught: " + e);
        }

        // use of throws
        try{
            fun1();
        }
        catch(IllegalAccessException e){
            System.out.println("Exception caught: " + e);
        }
    }
}

/*  EXPLANATION for throw:
    main() starts.
    main() calls fun().
    fun() enters try.
    throw new NullPointerException("demo") creates and throws the exception.
    catch (NullPointerException e) in fun() catches it.
    Prints Caught inside fun().
    throw e rethrows the same exception object.
    fun() stops and the exception propagates to its caller, main().
    main()'s catch (NullPointerException e) catches it.
    Prints Caught in main.
    main() finishes → program ends.
*/
