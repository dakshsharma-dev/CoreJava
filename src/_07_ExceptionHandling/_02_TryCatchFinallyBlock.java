package _07_ExceptionHandling;

public class _02_TryCatchFinallyBlock {
    public static void main(String[] args) {
        try{
            int res = 10 / 0; // Java encounters the problem and creates/throws an ArithmeticException OBJECT.
            // normal execution of the try block stops immediately. **The program does not continue to any remaining statements inside try.**

            String name = null;                                  // unreachable statement
            System.out.println(name.length());
        }
        catch(NullPointerException e){                           // More specific exceptions must come before broader ones:
            System.out.println("Exception caught: " + e);
        }
        catch(ArithmeticException e){                            // More specific exceptions must come before broader ones:
            System.out.println("Exception caught: " + e);
        }
        catch(Exception e){                                      // compiler will give an error if a broader exception comes first.
            System.out.println("Exception caught: " + e);
        }
        finally{                                                 // Used for cleanup tasks such as closing files or database connections.
            System.out.println("I am finally block. I will always execute whether an Exception occurs or not.");
        }

        System.out.println("Program continues....");

    }
}
/* EXPLANATION:

    ArithmeticException → type of the object
    e → reference variable (Java automatically gives e, the reference to the exception object that was thrown.)
    the thrown exception object → object that e refers to

    Think:
    ArithmeticException = type/class
    e                   = reference to the actual exception object


    NOTE: 1. A try block must be followed by at least one catch block or a finally block(try block can't exists alone)
            try, catch, and finally cannot exist as standalone blocks.
            valid combinations:
            try + catch
            try + finally
            try + catch + finally

    INTERNAL WORKING OF TRY-CATCH BLOCK:
    1. Java Virtual Machine starts executing the code inside the try block.
    2. If an exception occurs, the remaining code in the try block is skipped, and the JVM starts looking for the matching catch block.
    3. If a matching catch block is found, the code in that block is executed.
    4. After the catch block, control moves to the finally block (if present).
    5. If no matching catch block is found in the current method, the exception propagates up the call stack.
        If it remains unhandled all the way to main(), the JVM's default exception handler handles it.
    6. The finally block executes in most cases, even if an exception occurs, but it may not execute if the JVM exits abruptly (e.g., via System.exit()), crashes, or there’s an infinite loop before finally.

*/
