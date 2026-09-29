package _08_Generics;

//Generics allow Collections to enforce what types they can store and retrieve, giving compile-time type safety and eliminating unnecessary casting.

// Without Generics
// Java's old ArrayList stores objects without specifying a type:
// ArrayList list = new ArrayList();
// list.add("Daksh");
// list.add(10);

// Now:
// String name = (String) list.get(0);
// We need to cast because list.get(0) returns Object.
// And this is dangerous:
// String name = (String) list.get(1);  // 10 is an Integer, not a String, so this causes a ClassCastException at runtime


//With Generics
//ArrayList<String> list = new ArrayList<>();
//list.add("Daksh");
//list.add(10);    // ❌ Compile-time error

//And:
//String name = list.get(0);
//No casting required.

// <String> tells Java: This collection is meant to contain String values.


//One important terminology distinction:
//List<String>
//String is called a *****type argument*****  -> actual type supplied to that placeholder.
//
//class Box<T>
//T is called a      *****type parameter***** -> placeholder declared by the class.


/*
    // Common type parameter naming conventions:
    // T = Type, E = Element, K = Key, V = Value.
    // These are just conventional names, not Java keywords.
*/

public class _03_GenericsWithCollections {
    public static void main(String[] args) {

    }
}
