package _09_Collections._05_MapInterface;

import java.util.*;

/*
    Java Map Methods
    ----------------

    This class contains the commonly used Map methods,
    their concepts, examples, priorities, and important DSA patterns.
*/

public class _03_MapMethodsImportant {

    public static void main(String[] args) {

        /*
        ============================================================
        1. Basic Map methods
        ============================================================
        */

        /*
            put(key, value)

            Adds a key-value pair.
        */

        Map<Integer, String> mp = new HashMap<>();

        mp.put(1, "A");
        mp.put(2, "B");

        /*
            If the key already exists, its value is replaced.

            mp.put(1, "X");

            Now:

            1 → X
            2 → B
        */

        /*
            Important: put() returns the previous value.

            String old = mp.put(1, "Y");

            old will be "X".

            If the key didn't exist, it returns null.
        */

        String old = mp.put(1, "Y");


        /*
        ============================================================
        2. get(key)
        ============================================================
        */

        /*
            Returns the value associated with the key.

            If the key doesn't exist:

            mp.get(100); // null
        */

        String value = mp.get(1);

        /*
            Important pitfall

            null can mean either:

                key doesn't exist
                        OR
                key exists and its value is null

            So when this distinction matters:

                mp.containsKey(key)
        */


        /*
        ============================================================
        3. containsKey(key) ⭐
        ============================================================
        */

        /*
            Checks whether a key exists.

            Returns:

                true / false

            Very commonly used.
        */

        if (mp.containsKey(10)) {
            // key exists
        }


        /*
        ============================================================
        4. containsValue(value)
        ============================================================
        */

        /*
            Checks whether a value exists.

            Example:

                mp.containsValue("Alice");

            Usually less useful in DSA because it requires
            searching through the values.
        */

        boolean exists = mp.containsValue("Alice");


        /*
        ============================================================
        5. remove(key)
        ============================================================
        */

        /*
            Removes the mapping.

            It also returns the removed value.
        */

        String removed = mp.remove(10);


        /*
        ============================================================
        Now the more useful Java-specific methods
        ============================================================
        */


        /*
        ============================================================
        6. getOrDefault() ⭐⭐⭐
        ============================================================
        */

        /*
            This is very useful in DSA.

            Meaning:

                Give me the value for this key;
                if the key doesn't exist, give me the default value.
        */

        Map<Integer, Integer> freq = new HashMap<>();

        freq.put(5, 10);

        System.out.println(freq.getOrDefault(5, 0)); // 10
        System.out.println(freq.getOrDefault(7, 0)); // 0

        /*
            Extremely common frequency-map pattern

            Instead of:

                if (mp.containsKey(x)) {
                    mp.put(x, mp.get(x) + 1);
                } else {
                    mp.put(x, 1);
                }

            you can write:

                mp.put(x, mp.getOrDefault(x, 0) + 1);

            This is one of the most useful Map methods for DSA.
        */


        /*
        ============================================================
        7. putIfAbsent() ⭐⭐
        ============================================================
        */

        /*
            Meaning:

                Put this value only if the key doesn't already exist.
        */

        freq.putIfAbsent(10, 100);

        /*
            If:

                10 → B

            already exists, nothing happens.

            Compare:

                put()
                    → always replaces existing value.

                putIfAbsent()
                    → doesn't replace existing value.
        */


        /*
        ============================================================
        8. replace() ⭐⭐
        ============================================================
        */

        /*
            Replaces the value only if the key exists.
        */

        freq.replace(10, 200);

        /*
            If 10 exists:

                10 → old

            becomes:

                10 → 200

            If 10 doesn't exist, nothing is added.

            Compare:

                put()       → insert OR replace
                replace()   → replace only

            There is also:

                mp.replace(10, "A", "B");

            Meaning:

                Replace A with B for key 10,
                but only if its current value is A.
        */


        /*
        ============================================================
        9. computeIfAbsent() ⭐⭐
        ============================================================
        */

        /*
            This one looks complicated initially,
            but the idea is simple:

                If the key doesn't exist,
                calculate a value and insert it.
        */

        Map<Integer, List<Integer>> group = new HashMap<>();

        group.computeIfAbsent(5, k -> new ArrayList<>()).add(10);

        /*
            If key 5 doesn't exist:

                5 → new ArrayList<>()

            is created, and then 10 is added.

            So you can use this for grouping:

                Map<Integer, List<Integer>> mp = new HashMap<>();

                mp.computeIfAbsent(x, k -> new ArrayList<>()).add(y);

            This pattern is useful for:

                - adjacency lists
                - grouping elements
                - mapping one key to multiple values
        */


        /*
        ============================================================
        10. computeIfPresent()
        ============================================================
        */

        /*
            Opposite idea:

                Perform an operation only if the key already exists.
        */

        freq.computeIfPresent(10, (key, value1) -> value1 + 1);

        /*
            If 10 exists, its value is updated.

            If it doesn't exist, nothing happens.

            Less important for your current DSA level
            than computeIfAbsent().
        */


        /*
        ============================================================
        11. compute()
        ============================================================
        */

        /*
            Allows you to calculate/update a value regardless
            of whether the key exists.
        */

        freq.compute(
                10,
                (key, value1) -> value1 == null ? 1 : value1 + 1
        );

        /*
            Powerful, but you don't need to prioritise
            this right now.
        */


        /*
        ============================================================
        12. keySet(), values(), entrySet() ⭐⭐⭐
        ============================================================
        */

        Map<Integer, String> names = new HashMap<>();

        names.put(1, "A");
        names.put(2, "B");


        /*
            keySet()

            Gives a Set view of the keys.
        */

        Set<Integer> keys = names.keySet();

        /*
            {1, 2}
        */


        /*
            values()

            Gives a Collection of values.

            It is a Collection, not a Set,
            because values can repeat.
        */

        Collection<String> values = names.values();

        /*
            {A, B}
        */


        /*
            entrySet()

            Each Entry represents:

                key + value
        */

        Set<Map.Entry<Integer, String>> entries = names.entrySet();


        /*
            This is the preferred way to iterate
            over both keys and values.
        */

        for (Map.Entry<Integer, String> entry : names.entrySet()) {
            System.out.println(
                    entry.getKey() + " " + entry.getValue()
            );
        }


        /*
        ============================================================
        13. size(), isEmpty(), clear()
        ============================================================
        */

        /*
            Straightforward.
        */

        names.size();
        names.isEmpty();
        names.clear();


        /*
        ============================================================
        14. replaceAll()
        ============================================================
        */

        /*
            Updates every value using a function.
        */

        Map<Integer, Integer> numbers = new HashMap<>();

        numbers.put(1, 10);
        numbers.put(2, 20);

        numbers.replaceAll((key, value1) -> value1 + 1);

        /*
            Before:

                1 → 10
                2 → 20

            After:

                1 → 11
                2 → 21

            Not particularly important for DSA.
        */


        /*
        ============================================================
        What you should actually prioritise
        ============================================================
        */


        /*
            ⭐⭐⭐ Must know

                put()
                get()
                remove()
                containsKey()
                getOrDefault()

                keySet()
                values()
                entrySet()
        */


        /*
            ⭐⭐ Good to know

                putIfAbsent()
                replace()
                computeIfAbsent()
        */


        /*
            ⭐ Basic awareness

                computeIfPresent()
                compute()
                replaceAll()
        */


        /*
        ============================================================
        The most important DSA patterns
        ============================================================
        */


        /*
            Frequency counting
        */

        freq.put(5, freq.getOrDefault(5, 0) + 1);


        /*
            Check before accessing
        */

        if (freq.containsKey(5)) {
            // ...
        }


        /*
            Grouping
        */

        group.computeIfAbsent(5, k -> new ArrayList<>()).add(20);


        /*
            Iterate key + value
        */

        for (Map.Entry<Integer, String> entry : names.entrySet()) {
            // entry.getKey()
            // entry.getValue()
        }


        /*
            Iterate only keys
        */

        for (Integer key : names.keySet()) {
            // ...
        }


        /*
            Iterate only values
        */

        for (String value1 : names.values()) {
            // ...
        }


        /*
        ============================================================
        One important mental model
        ============================================================

            keySet(), values(), and entrySet() are views
            backed by the Map, not independent copies.

            That's why you can think of:

                Map
                ├── keySet()    → Set of keys
                ├── values()    → Collection of values
                └── entrySet()  → Set of key-value entries
        */
    }
}
