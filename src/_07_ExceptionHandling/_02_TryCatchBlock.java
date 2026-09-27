package _07_ExceptionHandling;

public class _02_TryCatchBlock {
    public static void main(String[] args) {
        try{
            int res = 10 / 0;  // Java encounters the problem and creates/throws an ArithmeticException OBJECT.
            // normal execution of the try block stops immediately. The program does not continue to any remaining statements inside try.
            System.out.println("Try Block completed");
        }
        catch(ArithmeticException e){
            System.out.println("Exception caught: " + e);
        }

        System.out.println("Program completed");
    }
}
/* EXPLANATION:

    ArithmeticException → type of the object
    e → reference variable (Java automatically gives e the reference to the exception object that was thrown.)
    the thrown exception object → object that e refers to

    i.e.
    If an ArithmeticException is thrown, give me a reference to that exception object through e

    Don't think:
    ArithmeticException = the actual exception
    e                   = the exception

    Think:
    ArithmeticException = type/class
    e                   = reference to the actual exception object

*/
