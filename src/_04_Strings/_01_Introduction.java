package _04_Strings;

public class _01_Introduction {
    public static void main(String[] args) {
        // Strings are immutable, meaning their value cannot be changed after creation.
        String name = "Daksh";
        name += "Sharma";
        // name now points to a new String object "DakshSharma" but the previous String object "Daksh" stays as it is in the string pool and becomes eligible for garbage collection if it is not referenced by some other variable -> Hence, Strings are immutable.
        // PROOF:
        String s = "Hello";
        String newS = s.concat(" World");   // concat() -> returns a new String
        System.out.println(s);                  // Hello not Hello World proves s is still Hello -> immutable
        System.out.println(newS);               // Hello World

        /*
            C++ char[]  → actual character array; characters are contiguous.
            Java char[] → actual character array; elements are contiguous.
            C++ std::string → object/class managing a contiguous character sequence internally.
            Java String → object/string abstraction; not necessarily backed by char[] (modern Java commonly uses byte[]).
            So, C++ std::string is essentially a character sequence with extra functionality, but it is not itself a raw char[].
        */
        /*
            Heap
            ├── String Pool
            │   └── "Hello"
            │
            └── Ordinary Objects
                └── new String("Hello")
        */


        // Ways Of Creating a Java String
        // 1. String literal (stored/reused through the String Pool)     // To make Java more memory efficient (because no new objects are created if it exists already in the string constant pool). Java stores string literals in the String Pool. If the same literal already exists in the pool, Java can reuse the existing String object.
        String s1 = "Hello";
        // s and s1(in stack) both refer to same string literal in pool "Hello"

        // 2. Using new keyword (Heap Memory)    // Using the new keyword creates a new object in heap memory, even if the same string already exists in the pool.
        String s2 = new String("Hello"); // discouraged // In modern Java, you generally should not use new String() just to create a String
        /*
            One object is created in the heap memory
            The string literal is stored in the string pool (if not already present)***********
            The reference variable points to the heap object, not the pool
        */

        /*
            "Hello" exists in the String Pool.
            new String("Hello") creates a separate String object in the heap.
            s2 points to that new object, not to the pooled one.
        */


    }
}
