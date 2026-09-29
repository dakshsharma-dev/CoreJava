package _08_Generics;
import java.util.List;

/*
    Wildcards — <?>
    ? -> some unknown type
    example: List<?> ls;
    ls is a List of some specific type, but I don't know or don't need to care what it is


    Why use '?' instead of 'T'
    List<T> → There is a specific type, and I care about/need to REFER to it.                 -> inplace of T, we will use some ObjectType while object creation
    List<?> → There is some specific type, but I don't know or don't need to care what it is. -> inplace of ?, we don't generally use any ObjectType while object creation
    Example:
    List<String> ls;   // specific type: String
    List<?> ls;        // unknown type
*/


public class _05_WildCards {
//    Why use wildcard?
//    Suppose we want a method that can accept a List of any type:
    static void display(List<?> ls){
        for(Object value: ls){
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Now all of these work:
        display(List.of("A", "B"));
        display(List.of(1, 2, 3));
        display(List.of(3.14, 2.5));

        /*
            Important limitation:
            You cannot safely add a specific value to List<?>:
            List<?> list = new ArrayList<String>();
            // list.add("Daksh");  // ❌

            Why?
                    Because Java doesn't know what the actual type is.
            It could be: List<Integer>
            and adding "Daksh" would be unsafe.

                    You can read from it: Object value = list.get(0);
            because whatever comes out is guaranteed to be an Object.
        */
    }
}

/*
    wildcard -> < ? extends T>  -> Some unknown type that is T or a subclass of T.
    class Animal{}
    class Dog extends Animal{}
    class Cat extends Animal{}

    List<? extends Animal> may refer to:
    List<Animal>
    List<Dog>
    List<Cat>
    but not:
    List<String>   // ❌

    Why is this useful?
    Suppose we only want to read Animals from a list:
    static void displayAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {
            // use a as an Animal
        }
    }

    We can pass:
    List<Dog>
    List<Cat>
    List<Animal>
    because all of them contain objects that are guaranteed to be Animals.

    The important limitation
    Just like <?>, you cannot add a specific object:

    List<? extends Animal> animals;
    animals.add(new Dog());   // ❌

    Because the actual list could be:
    List<Cat>
    and adding a Dog would be unsafe.

*/

/*
    <? super T>
    This is the opposite direction of <? extends T>.

    List<? super Integer>
    means: A List whose type is Integer or a superclass of Integer.

    So it can be:
    List<Integer>
    List<Number>
    List<Object>

    but not:
    List<Double>   // ❌
    List<String>   // ❌

    The practical reason
    With super, you can safely add T (and its subclasses).

    static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    This is safe because the actual list can be:
    List<Integer>  → Integer is accepted
    List<Number>   → Integer is accepted
    List<Object>   → Integer is accepted

    But when reading, you can only safely treat the result as Object:
    Object x = list.get(0);

    You cannot assume it's an Integer.

    Compare the three
    <?>                  → unknown type
    <? extends Integer>  → Integer or subclass → mainly READ
    <? super Integer>    → Integer or superclass → mainly WRITE
*/
