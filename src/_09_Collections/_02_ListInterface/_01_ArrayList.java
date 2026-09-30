package _09_Collections._02_ListInterface;

import java.util.ArrayList;
import java.util.List;

// 1.
// resizable array.
// Internally, it uses an array.
// ArrayList -> Object[]
// int[]               -> contiguous int values
// Integer[]           -> contiguous references
// ArrayList<Integer>  -> internally Object[] of contiguous references, actual Integer objects are elsewhere on the heap.


// 2.
// ArrayList allows null values.


// 3.
// How get(i) is O(1)
//ArrayList internally stores elements in a contiguous array.
//So to access index i, Java can directly calculate: base_address + (i × element_size)
//and jump to that position immediately.


// 4.
// size & capacity
//size     = actual number of elements
//capacity = internal array's available space
//
//When capacity is insufficient:
//→ larger array
//→ copy references
//→ continue
//
// add(element) -> amortized O(1)
// Occasionally O(n) when internal array needs resizing.


// 5.
//Java                 C++(STL)
//--------------------------------
//add(x)               push_back(x)
//add(i, x)            insert(iterator)
//get(i)               v[i]
//set(i, x)            v[i] = x
//remove(index/object) erase(iterator)
//contains(x)          find(iterator)


// 6.
//Ordered
//Indexed
//Allows duplicates


public class _01_ArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // add O(1)
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(3, 45); // similar to v.insert(v.begin() + 2, 32) in C++

        // printing elements
        System.out.println(list);  // [10, 20, 30]    // equivalent to     System.out.println(list.toString());
        // or
        for(int x: list) System.out.print(x + " ");   // 10 20 30
        System.out.println();
        // or
        for(int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");   // 10 20 30
        System.out.println();

        // access O(1)
        // System.out.println(list[0]);       // error
        System.out.println(list.get(0));   // 10

        // update O(1)
        list.set(0, 50);
        for(int x: list) System.out.print(x + " ");      // 50 20 30
        System.out.println();

        // remove O(n)
        list.remove(0);                        // remove by index
        // VERY IMPORTANT****************
        list.remove(Integer.valueOf(10));          // remove by value(10 doesn't exist anymore in list -> nothing will happen)
        for(int x: list) System.out.print(x + " ");   // 20 30
        System.out.println();

        // size O(1)
        System.out.println(list.size());              // 2

        // contains  O(n)  -> return true or false
        System.out.println(list.contains(20));        // true

        // searching O(n)
        System.out.println(list.indexOf(50));          // -1 // returns the index of the first occurrence else -1
        System.out.println(list.lastIndexOf(50));   // -1 // returns the index of the last occurrence else -1
    }
}
