package _04_Strings;

public class _02_StringMethods {
    public static void main(String[] args) {
        String a = "abcd";
        String b = "abcd";
        String c = new String("abcd");
        System.out.println(a == b);      // true
        System.out.println(b == c);      // false
        System.out.println(a.equals(c)); // true    // equals() method compares the content equality of two strings. // equals() can be overridden to define custom equality. // generally preferred for content comparison.
        System.out.println(b.equals(c)); // true

//        The '==' operator:
//        For primitive data types, it checks whether the values are equal. For objects, it checks whether both references point to the same object in memory.

//        IMPORTANT NOTE:
//        String      -> length()
//        Array       -> length
//        Collection  -> size()
//        Notice that length for arrays is a field/property, not a method, so there are no parentheses:

//        1. char charAt(int i)
        String str = "Hello World!!";
        System.out.println(str.charAt(0));
//        System.out.println(str[0]);   // Error // Java String does not support [] indexing.

//        2. String substring(int i, int j) // returns the substring from i to j-1 index
        System.out.println(str.substring(3, 7));              // lo W
        System.out.println(str.substring(3));      // lo World!! // endIdx is str.length()

//        3. String concat(String s)
        System.out.println(str.concat(" This is me, Daksh"));      // Hello World!! This is me, Daksh
        System.out.println(str + " This is me, Daksh");                // Hello World!! This is me, Daksh
//        Note : '+' operator can also concatenate other types.
        String s1 = "Age: " + 20;
        System.out.println(s1);                                        // Age: 20

//        4. int indexOf(String s, int i)  // returns the index of the first occurrence of the specified string, starting at the specified index. ELSE RETURN -1;
        System.out.println(str.indexOf("W"));     // 6 // by default starting index is 0;
        System.out.println(str.indexOf("This"));  // -1 as str = "Hello World!!"

        String s2 = "this that this these those";
        System.out.println(s2.indexOf("this", 1)); // 10

//        5. int lastIndexOf(String s) // returns the index within the string of the last occurrence of the specified string ELSE RETURN -1;
        System.out.println(str.lastIndexOf("ld"));           // 9
        System.out.println(str.lastIndexOf("t"));            // -1

//        6. boolean equalsIgnoreCase(String s)  // checks if two strings are equal, without considering letter case.
        String s3 = "Daksh";
        System.out.println(s3.equalsIgnoreCase("daksh"));

//        7. int compareTo(String s)             // compares two string lexicographically.
        System.out.println(s3.compareTo("daksh"));
        /*
            0  -> Strings are equal
            <0 -> First String comes before second
            >0 -> First String comes after second
        */

//        8. int compareToIgnoreCase(String s)
        System.out.println(s3.compareToIgnoreCase("daksh")); // ignore the case of letters while comparing

//        9. toLowerCase() toUpperCase()
        System.out.println(s3.toUpperCase());
        System.out.println(s3.toLowerCase());

//        10. String trim() // returns the copy of the String, by removing whitespaces at both ends
        String s4 = "   Daksh   Sharma     ";
        System.out.println(s4.trim());

//        11. String replace(old char, new char) or String replace(old charSequence, new charSequence)
        String s5 = "Daksh Sharma";
        System.out.println(s5.replace('a', 'i'));
        System.out.println(s5.toLowerCase().replace("sh", "pq"));

//        12. boolean contains(charSequence)
        System.out.println(s5.contains("ak"));
        System.out.println(s5.contains("ka"));

//        13. char[] toCharArray() // converts the string into a new character array.
        char[] charArr = s5.toCharArray();
        for(char ch: charArr){
            System.out.print(ch + " ");
        }
        System.out.println();

//        14. boolean startsWith(String prefix)
        System.out.println(s5.startsWith("Dak"));
        System.out.println(s5.startsWith("dak"));


    }
}
