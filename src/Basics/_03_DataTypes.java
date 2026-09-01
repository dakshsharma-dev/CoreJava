package Basics;

public class _03_DataTypes {
    public static void main(String[] args){
        long a = 1338083903833820L;  // L needed
        float b = 34343.4334F;       // F needed
        /*
             why
             Because Java determines the type of the literal first, before assigning it.
             Integer literal → int by default
             Decimal literal → double by default
             So,
             long a = 1338083903833820; // ❌ integer literal is int and value doesn't fit in int
             float b = 34343.4334;      // ❌ Literal is double, and Java doesn't implicitly narrow double → float because it may lose precision.

             L and F tell the compiler: "Treat this literal as a long/float
             Lowercase l and f are also valid, but l is discouraged because it looks like 1
             Therefore, uppercase L and F are preferred
         */
    }
}
/*

* MUTABILITY VS IMMUTABILITY
*
* Mutable     → The existing object can be modified after creation.
* Immutable   → The existing object cannot be modified after creation.
*
* Important: Reassigning a variable and modifying an object are different things.
*
*
* PRIMITIVE DATATYPES
*
* Primitive variables directly store their values, so they can simply be reassigned:
*
* ```
  int a = 5;
  ```
* ```
  a = 6;             // Reassignment — allowed
  ```
*
* Here, a now stores 6. There is no object being modified.
*
*
* REFERENCE TYPES
*
* Reference variables store a reference to an object:
*
* ```
  String s = "Hello";
  ```
* ```
  s = "World";       // Reassignment — allowed
  ```
*
* This does not modify "Hello"; s simply refers to another String.
* If "Hello" has no other references, it becomes eligible for Garbage Collection (GC).
*
* For a mutable object:
*
* ```
  int[] arr = {1, 2, 3};
  ```
* ```
  arr[0] = 10;       // Modifies the existing array
  ```
*
* Arrays are mutable in Java.
*
*
* JAVA VS C++
*
* Java String       → Immutable
* Java arrays       → Mutable
* C++ std::string   → Mutable
*
* ```
  string s = "Hello";
  ```
* ```
  s[0] = 'J';       // Modifies the existing string → "Jello"
  ```
*
*
* KEY TAKEAWAY
*
* Primitive variable  → Directly stores a value and can be reassigned.
* Reference variable  → Stores a reference and can be reassigned to another object.
* Mutation            → Modifies the existing object itself.
* Reassignment        → Changes the value/reference stored in the variable.
*
* Reassignment and mutation are different operations.
  */

