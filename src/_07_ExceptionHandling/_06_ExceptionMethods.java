package _07_ExceptionHandling;

public class _06_ExceptionMethods {
    public static void main(String[] args) {
        try{
            int res = 10 / 0;
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());  // Returns the message that was given when the exception was created.
            System.out.println(e.toString());    // Returns the exception class name + message.
            e.printStackTrace();                 // Prints the exception type, message, and stack trace — basically showing where the exception occurred and how the program reached that point.
        }
    }
}
