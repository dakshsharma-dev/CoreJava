package _09_Collections._05_MapInterface;

import java.util.HashMap;
import java.util.Map;

/*
    1.
    key is unique, but values can be duplicated.

    2.
    uses hash table → average O(1) lookup/insertion/removal.

    3.
    HashMap: does not guarantee ordering
    LinkedHashMap is basically: HashMap + insertion-order preservation
    TreeMap: sorted keys

    4. methods
    put(key, value)
    get(key)
    remove(key)
    containsKey(key)
    containsValue(value)
    size()
    isEmpty()
    clear()
 */
public class _01_HashMapAndLinkedHashMap {
    public static void main(String[] args) {
        Map<Integer, String> mp = new HashMap<>();
        // Methods
        mp.put(1, null);
        mp.put(2, "Daksh");
        System.out.println(mp); // {1=null, 2=Daksh}
        mp.put(1, "Shreya");    // replaces old value where key = 1
        System.out.println(mp); // {1=Shreya, 2=Daksh}


        System.out.println(mp.get(1));          // Shreya
        System.out.println(mp.remove(1));  // Shreya // remove also return the value which is removed

        System.out.println(mp.containsKey(1));  // false
        System.out.println(mp.containsValue("Daksh")); // true

        System.out.println(mp.size());      // 1
        System.out.println(mp.isEmpty());   // false
        mp.clear();



    }
}
