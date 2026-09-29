package _08_Generics;

//Generics allow us to write reusable code that works with different types while providing compile-time type safety.

// 1. Why Generics exists?
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
//Declared with a type parameter (e.g., <T>) after the class name.
//Multiple type parameters can be used (e.g., <T, U>). // Example: Pair<K, V>, Map<K, V>
//Type parameters must be reference types (not primitives like int, float, etc.).


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
class AnotherBox<T>{            // here 'T' is a type parameter
    T value;

    AnotherBox(T value){
        this.value = value;
    }

    T getValue(){
        return value;
    }
}

public class _01_Introduction {
    public static void main(String[] args) {
        // Without Generics
        Box box = new Box("Daksh");
        System.out.println(box.getValue());

        Box box1 = new Box(1);
        System.out.println(box1.getValue());

//        problem appears when you want to use the value as a specific type:
        String name = (String) box.getValue();   // OK
        String s = (String) box1.getValue();     // Runtime ClassCastException


        // With Generics
        AnotherBox<String> abox = new AnotherBox<>("Sneha");
        System.out.println(abox.getValue());

        AnotherBox<Integer> abox1 = new AnotherBox<>(2);
        System.out.println(abox1.getValue());

//        Generics prevent such mistakes at compile time:
//        String s1 = abox1.getValue();  // Compile-time error
    }
}
