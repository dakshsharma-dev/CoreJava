package _09_Collections._01_CollectionsFrameworkBasics;

/*  I -> interface, C -> class, L -> legacy class
    [I] Iterable
    └── [I] Collection                    extends Iterable
        │
        ├── [I] List                      extends Collection
        │   ├── [C] ArrayList             implements List
        │   ├── [C] LinkedList            implements List, Deque
        │   └── [L] Vector                implements List
        │       └── [L] Stack             extends Vector
        │
        ├── [I] Queue                     extends Collection
        │   ├── [C] PriorityQueue         implements Queue
        │   └── [I] Deque                 extends Queue
        │       ├── [C] ArrayDeque        implements Deque
        │       └── [C] LinkedList        implements Deque (same class as under List)
        │
        └── [I] Set                       extends Collection
            ├── [C] HashSet               implements Set
            │   └── [C] LinkedHashSet     extends HashSet
            └── [I] SortedSet             extends Set
                └── [C] TreeSet           implements SortedSet


    [I] Map                               (separate tree, NOT part of Collection)
    ├── [C] HashMap                       implements Map
    │   └── [C] LinkedHashMap             extends HashMap
    ├── [L] Hashtable                     implements Map
    └── [I] SortedMap                     extends Map
        └── [C] TreeMap                   implements SortedMap

*/


/*  Points to remember
    1. use the highest-level interface that provides the operations you need.
        ArrayList<Integer> list = new ArrayList<>();
        instead of this, use below one because it makes code less dependent on the specific implementation.
        List<Integer> list = new ArrayList<>();


    2. LinkedList is interesting:
        it implements both List & Deque, and therefore Queue.
        List<Integer> list = new LinkedList<>();   -> List specific operations
        or
        Deque<Integer> deque = new LinkedList<>(); -> Queue specific operations


    3. Legacy Class: basically means they are older classes from early Java.
        Vector → older alternative to ArrayList
        Stack → older stack implementation; Deque/ArrayDeque is generally preferred
        Hashtable → older alternative to HashMap

        They are still part of Java, but generally less preferred in new code because newer collection classes provide better/more flexible designs.


    4. Map   ← separate hierarchy
        Because a Collection stores individual elements:
        List → [10, 20, 30]
        Set  → [10, 20, 30]

        A Map stores key-value pairs:
        Map → {101="Daksh", 102="Rahul", 103="Aman"}

    5.  Note:
        mp.keySet()   -> Set<K>
        mp.values()   -> Collection<V>
        mp.entrySet() -> Set<Map.Entry<K, V>>

        Since Set extends Collection, these returned objects belong to the Collection hierarchy even though Map itself does not.

        Map           -> NOT a Collection
        Map views     -> Collection types
*/
public class _02_CollectionAndMapHierarchy {
    public static void main(String[] args) {

    }
}
