package _08_Generics;

//Generics allow us to write reusable code that works with different types while providing compile-time type safety.

// 1. Why Generics exists?***************************
    //Type safety
    //Avoiding unnecessary casting


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

// NOTE:
// ArrayList<String> list = new ArrayList<>();
// Diamond operator(<>): compiler infers the generic type from the LHS, so <String> need not be repeated on RHS.

// NOTE:
//Generics don't exist only for Collections.
//They allow us to write reusable classes, methods and interfaces while still maintaining type safety.



// 2. Generic Classes
//class that can work with different data types, where the type is specified when creating the object.
//Declared with a TYPE PARAMETER (e.g., <T>) after the class name.
//Multiple TYPE PARAMETERS can be used (e.g., <T, U>). // Example: Pair<K, V>, Map<K, V>
//TYPE PARAMETERS must be reference types (not primitives like int, float, etc.).

// NOTE: TYPE PARAMETER, is a very important term in Generics.


// Without Generics
class Box{
    Object value;

    Box(Object value){
        this.value = value;
    }

    Object getValue(){
        return value;
    }
}

// With Generics
class AnotherBox<T>{            // here 'T' is a TYPE PARAMETER
    T value;

    AnotherBox(T value){
        this.value = value;
    }

    T getValue(){               // concrete method with returnType T
        return value;
    }
}

public class _01_GenericClassesAndMethods {
    // 3. Generic Methods: method that introduces its own type parameter, independent of whether the class itself is generic.

    static <T> void display(T value){  // TYPE PARAMETER is mandatory just before returnType
        System.out.println(value);
    }

    static <T> T show(T value){        // returnType T // TYPE PARAMETER is mandatory just before returnType
        return value;
    }

    public static void main(String[] args) {
        // Without Generics
        Box box = new Box("Daksh");
        System.out.println(box.getValue());

        Box box1 = new Box(1);
        System.out.println(box1.getValue());

//        problem appears when you want to use the value as a specific type:
//        String name = (String) box.getValue();   // OK
//        String s = (String) box1.getValue();     // Runtime ClassCastException


        // With Generics
        AnotherBox<String> abox = new AnotherBox<>("Sneha");
        System.out.println(abox.getValue());

        AnotherBox<Integer> abox1 = new AnotherBox<>(2);
        System.out.println(abox1.getValue());

//        Generics prevent such mistakes at compile time:
//        String s1 = abox1.getValue();  // Compile-time error


        // Generic Methods: same method works for different types.
        display("Aryan");
        display(3);
        display(3.1343);

        System.out.println(show("Asha"));
        System.out.println(show(1));

    }
}
