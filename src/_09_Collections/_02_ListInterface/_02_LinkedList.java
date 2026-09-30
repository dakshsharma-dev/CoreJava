package _09_Collections._02_ListInterface;
/*
    1.
    Java's LinkedList is a doubly linked list.
    [prev | data | next] ⇄ [prev | data | next] ⇄ [prev | data | next]
    Unlike ArrayList, elements are not stored in a contiguous array.

    2.
    LinkedList implements both:
    List
    Deque

    Use the reference based on what you want the object to behave as:
    List<Integer> list = new LinkedList<>();  → when you need List operations like get(), set(), add(index, x), etc.
    Deque<Integer> deque = new LinkedList<>(); → when you need deque operations like addFirst(), addLast(), removeFirst(), removeLast(), etc.
    LinkedList<Integer> list = new LinkedList<>(); → when you specifically need both List and Deque APIs.

    General rule: use the most specific interface you actually need, not the concrete LinkedList type.
    The benefit is that you can later change the implementation easily, without changing the rest of your code as methods would be same.
    List<Integer> list = new ArrayList<>();
    or
    list = new LinkedList<>();
    Simple rule: Reference type = what you need; object type = how it's implemented.

    3.
    Java LinkedList → get(index) exists → O(n)
    C++ std::list   → indexing doesn't exist
    Java can't directly jump to index i, it must traverse
*/


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _02_LinkedList {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        // List specific methods
        list.add(10);
        list.add(50);
        list.add(80);                    // O(1)
        System.out.println(list.get(1)); // O(n)
        list.set(1, 100);                // O(n)
        list.remove(2);            // O(n)
        System.out.println(list.size());
        System.out.println(list);


        Deque<Integer> list1 = new LinkedList<>();
        // Deque specific methods
        list1.addFirst(10);   // O(1)
        list1.addLast(20);    // O(1)

        System.out.println(list1.getFirst());  // O(1)
        System.out.println(list1.getLast());   // O(1)

        list1.removeFirst();                  // O(1)
        list1.removeLast();                   // O(1)

        System.out.println(list1);

    }
}
