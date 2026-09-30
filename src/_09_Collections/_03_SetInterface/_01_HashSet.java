package _09_Collections._03_SetInterface;

import java.util.HashSet;
import java.util.Set;

/*
    1.
    don't allow duplicates
    use hashing
    doesn't guarantee sorted order
    does not guarantee insertion order.
    no indexing


    2. This is very important.
    How does HashSet detect duplicates?
    For objects, HashSet uses:
    hashCode()
       ↓
    find candidate location/bucket
       ↓
    equals()
       ↓
    determine whether it is actually equal
    So: equals() + hashCode() determine duplicate behavior in a HashSet.


    3.
      HashSet allows one null value.


    4.
     Average case: add(), remove(), contains() -> O(1)

     Worst case can degrade to O(n) due to hash collisions, but we usually consider O(1).
 */
public class _01_HashSet {
    public static void main(String[] args) {
        Set<Integer> st = new HashSet<>();
        st.add(1);               // O(1)
        st.add(2);
        st.add(3);
        System.out.println(st); // equivalent to System.out.println(st.toString());

        st.remove(2);        // O(1) // remove(Object)          not remove(index) as no indexing in Set

        System.out.println(st.contains(3)); // O(1)

        System.out.println(st.size());      // O(1)

        System.out.println(st.isEmpty());   // O(1)

        st.clear();                         // O(n)

        System.out.println(st); // equivalent to System.out.println(st.toString());


        // Important Note:
        System.out.println(st.add(4)); // true ->  element was actually added
                                       // false -> element already existed
    }
}
