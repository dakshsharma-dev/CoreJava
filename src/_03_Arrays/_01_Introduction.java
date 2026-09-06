package _03_Arrays;

class Student{
    int rollNo;
    String name;

    Student(int rollNo, String name){
        this.rollNo = rollNo;
        this.name = name;
    }
}
public class _01_Introduction {
    public static void main(String[] args){
        /*
            1. Java arrays can hold both primitive types (like int, char, boolean, etc.) and objects (like String, Integer, etc.)
            2. When we use arrays of primitive types, the elements are stored in contiguous locations. For non primitive types, REFERENCES to items are stored at contiguous locations.
            3. After creating an array, its size is fixed; we can not change it.
            4. Traditional Java arrays provide only the `.length` property; operations like `sort()`, `fill()`, `binarySearch()`, and `toString()` are available through the built-in `Arrays` utility class.
        */

        // Declaration
        // Syntax: dataType[] arrayName (recommended) or dataType arrayName[] (legacy style, not recommended)


        // Creation/Allocation
        // Syntax: dataType[] arrayName = new dataType[size]; {filled with 0 for int[] array by default}
        int[] arr = new int[5];
        for(int num: arr) System.out.print(num + " ");       // 0 0 0 0 0
        // When an array is declared, only a reference variable is created.
        // Memory for the array is allocated using the 'new' keyword.
        // Arrays are objects in Java, and array memory is allocated on the heap.


        // Initialization
        int[] arr1 = {1, 2, 3, 4, 5};
        for(int num: arr1) System.out.print(num + " ");      // 1 2 3 4 5
        // OR
        // int[] arr = new int[]{1, 2, 3, 4, 5};

        System.out.println();


        // Array of Objects
        Student[] students = new Student[5];
        students[0] = new Student(1, "Daksh");
        students[1] = new Student(2, "Sneha");
        students[2] = new Student(3, "Aadi");
        students[3] = new Student(4, "Shreya");
        students[4] = new Student(5, "Asha");

        for(Student st: students){
            // System.out.println(st);  // prints the object reference by default.
            System.out.println(st.rollNo + " " + st.name);
        }
    }
}
