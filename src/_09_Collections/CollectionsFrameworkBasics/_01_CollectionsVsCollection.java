package _09_Collections.CollectionsFrameworkBasics;

/*  Collections vs Collection
    1. Collection is an interface.

    Collection<Integer> c = new ArrayList<>();
    Collection is acting as a reference type (interface).

    2. Collections: is a utility class.
    contains static helper methods like sort(), reverse() etc.
    No objects are needed to call methods
    Collections.sort(ls);                                // C++ -> sort(v.begin(), v.end());
    Collections.reverse(ls);                             // C++ -> reverse(v.begin(), v.end());

    // Note: You can't do new Collection<>(); as we can't create objects of interface
    // Note: Map does NOT extend Collection. Map is a separate hierarchy

*/

/*  Iterable
    root interface of the Collections Framework.

    Iterable
       ↑
    Collection
       ↑
    List, Set, Queue

    Purpose: If a class implements Iterable, Java can loop through its elements.
    enhanced for-each loop works because classes like ArrayList, HashSet ultimately implement Iterable.


    NOTE: for (int x : list)
    1. is not special syntax only for collections, it works on anything that implements Iterable (and arrays).
    2. Java is internally using an Iterator obtained from list.iterator()
*/


public class _01_CollectionsVsCollection {
    public static void main(String[] args) {

    }
}
