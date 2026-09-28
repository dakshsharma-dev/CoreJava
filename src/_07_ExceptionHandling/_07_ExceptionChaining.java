package _07_ExceptionHandling;

//One exception is caused by another exception, and we preserve the original exception as the cause.

public class _07_ExceptionChaining {
    static void divide(){
        try{
            int res = 10 / 0;
        }
        catch(ArithmeticException e){
            // throw new RuntimeException("Calculation Failed", e);    // second argument e is stored as the cause of that new exception
            // OR
            RuntimeException rx = new RuntimeException("Calculation Failed");
            rx.initCause(e);                                           // set e as the cause of rx
            throw rx;
        }
    }
    public static void main(String[] args) {
        try{
            divide();
        }
        catch(RuntimeException e){
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
    }
}
