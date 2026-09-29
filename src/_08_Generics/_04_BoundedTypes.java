package _08_Generics;

//used when you don't want to allow every possible type as a generic type argument.

public class _04_BoundedTypes {
    static <T> void show(T value){
        System.out.println(value);
    }

    static <T extends Number> void display(T value){      // T must be Number or a subclass of Number.
        System.out.println(value);
    }
//    Why is this useful?
//    Because now inside the method, Java knows that T is a Number, so you can use Number's methods:

    public static void main(String[] args) {
        show(2);
        show(4.5);
        show(434322248324324L);
        show("Daksh");

        // Bounded types
        display(1);
        display(3.5);
        display(3043848348324324L);
        // display("Daksh");   // compile-time Error


        // NOTE: extends here means "is-a subclass of / implements", so it can also be used with interfaces:
        //<T extends Comparable<T>>
    }
}
