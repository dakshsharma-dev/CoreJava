package _09_Collections._05_MapInterface;

/*
    1.
    Internally, TreeMap uses a Red-Black Tree.
    put() → O(log n)
    get() → O(log n)
    remove() → O(log n)
    containsKey() → O(log n)


    2.
    put(key, value)          → O(log n)
    get(key)                 → O(log n)
    remove(key)              → O(log n)
    containsKey(key)         → O(log n)
    containsValue(value)     → O(n)      // because TreeMap is ordered by keys, so values must be searched linearly.
    size()                   → O(1)
    isEmpty()                → O(1)
    clear()                  → O(n)

    TreeMap specific methods: similar to TreeSet but TreeMap returns keys

    firstKey()               → O(log n)
    lastKey()                → O(log n)
    lowerKey(x)              → O(log n)  // largest key < x
    higherKey(x)             → O(log n)  // smallest key > x
    floorKey(x)              → O(log n)  // largest key <= x
    ceilingKey(x)            → O(log n)  // smallest key >= x

 */

public class _02_TreeMap {
    public static void main(String[] args) {

    }
}
