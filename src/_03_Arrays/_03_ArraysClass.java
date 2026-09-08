package _03_Arrays;

import java.util.Arrays;

public class _03_ArraysClass {
    public static void main(String[] args){
        /*
            1. A utility class that provides static(called directly with class name) methods to perform operations like sorting, searching, comparing, and converting arrays.
            2. It cannot be instantiated and is used only for utility purposes.
            3. Arrays is a final utility class in java.util package that extends Object class, which is the root of the Java class hierarchy
            4. public final class Arrays // final -> this class can't be extended
         */

        // 1. sort():                Syntax: Arrays.sort(arrayName);
        // 2. binarySearch method(): Syntax: Arrays.binarySearch(arrayName, key) // if the element is found, it returns its index; otherwise, it returns a NEGATIVE VALUE INDICATING THE INSERTION POINT.
        int[] arr = {3, 4, 1, 56, 22};
        Arrays.sort(arr);

        int key = 22;
        int idx = Arrays.binarySearch(arr, key);
        if(idx < 0) System.out.println(key + " not found.");
        else System.out.println(key + " found at " + idx + " index");

        // 3. Arrays.compare(arr1, arr2) // Compares two arrays lexicographically. It returns 0 if arrays are equal, a negative value if the first array is smaller, and a positive value if the first array is greater.
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {5, 6, 7, 8};
        int[] a3 = {1, 2, 3, 4};
        System.out.println(Arrays.compare(a1, a2)); // -1
        System.out.println(Arrays.compare(a2, a1)); // 1
        System.out.println(Arrays.compare(a1, a3)); // 0

        // 4. Arrays.toString()
        System.out.println(Arrays.toString(a1));   // Returns a string representation of the array, e.g. "[1, 2, 3]"


        // 5. Arrays.fill();
        int[] a4 = new int[5];
        Arrays.fill(a4, -1);                   // Fills all elements with the given value
        for(int num: a4) System.out.print(num + " ");
        System.out.println();


        // 6. Arrays.equals()
        System.out.println(Arrays.equals(a1, a3)); // Returns true if both arrays have the same elements in the same order else false
    }
}
