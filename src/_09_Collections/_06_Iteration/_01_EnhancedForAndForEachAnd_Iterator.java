package _09_Collections._06_Iteration;

import java.util.*;

public class _01_EnhancedForAndForEachAnd_Iterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Daksh");
        list.add("Sneha");


        // 1. Enhanced for loop
        System.out.println("Enhanced for loop: ");
        for(String name: list){
            System.out.println(name);
        }

        /*
            For a Map, you can't directly do:
            for (var x : map) { } // ❌

            Instead, use one of its views:
            for (String key : map.keySet()) { }
            for (String value : map.values()) { }
            for (Map.Entry<Integer, String> entry : map.entrySet()) { }

         */


        // 2. forEach method
        System.out.println("forEach method: ");
        list.forEach(name -> System.out.println(name));

        // You can also use a method reference: shorter version of above one
        System.out.println("Method Reference: ");
        list.forEach(System.out::println);               // For each element, call System.out.println() with that element.

        // forEach on a map
        System.out.println("forEach on Map");
        Map<Integer, String> mpp = new HashMap<>();
        mpp.put(1, "Daksh");
        mpp.put(2, "Sneha");

        mpp.forEach((key, value) -> {
            System.out.println("Key: " + key + " Value: " + value);
        });


        // 3. Iterator: gives you explicit control over traversal.
        // Important Methods:
//        hasNext() → is there another element?
//        next()    → give me the next element
//        remove()  → remove the last element returned by next()


        System.out.println("Using Iterator: ");
        Iterator<String> it = list.iterator();
//        Iterator<String> → the reference type
//        names.iterator() → returns an actual Iterator object
//        it → stores the reference to that object

        while(it.hasNext()){
            String name = it.next();
            System.out.println(name);
            if(name.equals("Daksh")) it.remove();
        }
        System.out.println(list); // [Sneha]

        /* EXPLANATION:
            The iterator initially starts BEFORE the first element.************************[IMPORTANT]
            hasNext()
                → checks whether there is a next element.

            next()
                → returns that next element
                → moves the iterator forward.
         */



        // 4. ListIterator: specifically for List & extends the capabilities of Iterator.
        /*
            can move in both direction
            forward  → next()
            backward → previous()
         */






    }
}
