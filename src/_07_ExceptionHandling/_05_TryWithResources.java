package _07_ExceptionHandling;

/*
     1. First understand the problem

        Suppose you open a resource:
        FileReader reader = new FileReader("data.txt");
        After using it, you need to close it:
        reader.close();

        If an exception occurs while working with it, you need to make sure close() still happens.
        Traditionally, you'd use finally:

        FileReader reader = null;
        try {
             reader = new FileReader("data.txt");
             // use reader
        }
        finally {
             if (reader != null) {
                 reader.close();
             }
        }
        That's quite verbose.


     2. Try-with-resources solves this
        try (FileReader reader = new FileReader("data.txt")) {
            // use reader
        }

        Java automatically closes reader when the try block finishes.
        Whether it finishes:
            normally ✅
            because of an exception ✅

        Core idea: Try-with-resources automatically closes resources after you're done with them.


     3. What is a resource?
           Something that needs to be closed after use.
           Examples: FileReader, BufferedReader, file streams, database connections, etc.

     4. AutoCloseable
           Try-with-resources works with objects that implement AutoCloseable(interface).
           AutoCloseable provides the close() method that Java calls automatically.

     5. catch / finally relationship

           try (FileReader reader = new FileReader("data.txt")) {
               // use reader
           }
           catch (IOException e) {
               // handle exception
           }
           finally {
               // optional
           }
*/

public class _05_TryWithResources {
    public static void main(String[] args) {

    }
}
