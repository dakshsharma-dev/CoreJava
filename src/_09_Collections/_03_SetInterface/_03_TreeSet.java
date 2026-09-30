package _09_Collections._03_SetInterface;
/*
    1.
    Elements sorted
    Implementation: TreeSet   uses→    TreeMap    uses→     Red-Black Tree.****************

    2.
    Method        Complexity  Function
    ------------  ----------  -----------------------------------------------
    COMMON METHODS
    add(x)        O(log n)    Adds x if not already present
    remove(x)     O(log n)    Removes x
    contains(x)   O(log n)    Checks whether x exists
    size()        O(1)        Number of elements
    isEmpty()     O(1)        Checks whether empty
    clear()       O(n)        Removes all elements

    TREESET'S SPECIFIC METHODS
    first()       O(1)*       Smallest element (java specific)
    last()        O(1)*       Largest element  (java specific)
    lower(x)      O(log n)    Largest element < x
    higher(x)     O(log n)    Smallest element > x
    floor(x)      O(log n)    Largest element <= x
    ceiling(x)    O(log n)    Smallest element >= x

    analogy to learn
    lower/floor     -> LARGEST  & less
    higher/ceiling  -> SMALLEST & greater

    3.
    No null values are allowed

*/
public class _03_TreeSet {
    public static void main(String[] args) {

    }
}
