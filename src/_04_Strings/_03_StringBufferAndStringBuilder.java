package _04_Strings;

public class _03_StringBufferAndStringBuilder {
    public static void main(String[] args) {
        /*
            char[]        → actual character array
            String        → immutable character sequence object    -> change ⇒ new String object(String refer to new object, it doesn't modify the previous String object)
            StringBuffer  → mutable character sequence object      -> change ⇒ same object is updated
            StringBuilder → mutable character sequence object      -> change ⇒ same object is updated

            String        → thread-safe     & generally slow
            StringBuilder → not thread-safe & generally faster     -> performs better in single-threaded applications.
            StringBuffer  → thread-safe     & generally slower     -> ******Use StringBuffer only when thread safety is required; otherwise, prefer StringBuilder for improved performance.
        */
//        StringBuffer class in Java represents a sequence of characters that can be modified.
//        ****All methods of StringBuffer are synchronized, making it safe to use in multithreaded environments.****


//        Ways of creating StringBuffer() and StringBuilder()
        StringBuffer sb1 = new StringBuffer();                   // same for StringBuilder()
        sb1.append("Hello");

        StringBuilder sb2 = new StringBuilder("Hello");          // same for StringBuffer()
        sb2.append(" Java");

        System.out.println("Default Constructor: " + sb1);
        System.out.println("String Constructor: " + sb2);

//        Methods for StringBuffer and StringBuilder are same
        sb1.insert(1, "Java");
        System.out.println(sb1);


        sb2.replace(1, 7, "Daksh"); // replace() method replaces the given string from the specified beginIndex and endIndex-1.
        System.out.println(sb2);

        sb2.delete(1, 7);                          // delete() method is used to delete the string from the specified beginIndex to endIndex-1
        System.out.println(sb2);


        System.out.println(sb1.length());


        sb1.reverse();
        System.out.println(sb1);

//        Note: String doesn't have built-in reverse() method
//        For a String, you'd typically use:
//        String s = new StringBuilder(str).reverse().toString();


        /*  USE CASE:
            - If the text is constant/normal text → use String because it is immutable.

            - If the text needs frequent modification and is used in a single-threaded context
              → use StringBuilder because it is mutable and faster.

            - If the text needs frequent modification and is shared across multiple threads
              → use StringBuffer because it is synchronised/thread-safe.
        */


    }
}
