package _09_Collections._08_CollectionsUtilityClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
    String name;
    int id;
    int age;
    double marks;

    public Student(String name, int id, int age, double marks) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        // Ascending order
        if(this.id < other.id) return -1;
        else if(this.id > other.id) return 1;
        else return 0;

        // Descending Order
//        if(this.id < other.id) return 1;
//        else if(this.id > other.id) return -1;
//        else return 0;

    }




    @Override
    public boolean equals(Object obj) {
        Student other = (Student) obj;
//        if(this.age == other.age && this.name.equals other.name) && this.id == other.id && this.marks == other.marks) return true;
        return this.id == other.id;
    }
    // Override equals() to define when two Student objects should be considered equal.
    // This equality is used by methods such as contains(), remove(Object), indexOf(),
    // lastIndexOf(), Collections.frequency(), and by HashSet/HashMap.
    // Here, two Students are considered equal if their id is the same.




    @Override
    public String toString() {
        return "Student{Name: " + name + ", id: " + id + ", age: " + age + ", marks: " + marks + "}";
    }
    // Override toString() so Student objects are displayed with their actual field values
    // instead of Object's default ClassName@hashCode representation.
}

public class _01_UtilityImportantMethods {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Daksh", 1, 21, 99.86));
        list.add(new Student("Sneha", 2, 24, 98.45));
        list.add(new Student("Aryan", 3, 20, 99.75));
        list.add(new Student("Shreya", 4, 21,  99.86));

        Comparator<Student> byAge = (s1,  s2) -> {
            if(s1.age < s2.age) return -1;
            else if(s1.age > s2.age) return 1;
            else return 0;
        };

        // Note: Collections utility methods that modify/rearrange a collection generally operate on the existing collection in-place rather than creating a new collection.
//        Collections → generally modifies existing collection
//        String      → operations return a new String

        Collections.reverse(list);   // Reverses the existing order.
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        list.sort(byAge);            // instance method, Comparator required
        System.out.println(list);

        Collections.shuffle(list);   // Randomly rearranges the elements.
        System.out.println(list);

        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));

//        For a List<Student>, Collections.min() / max() need to know how Students are **ORDERED**.
//        Using Comparable
//          or
//        Using Comparator

        System.out.println(Collections.min(list, byAge));
        System.out.println(Collections.max(list, byAge));



        Student st = new Student("Daksh", 1, 21, 99.86);
        System.out.println(Collections.frequency(list, st));
        System.out.println(Collections.frequency(list, new Student("Daksh", 1, 21, 99.86)));
//        newly created Student is a different object, so inherited Object.equals() considers them unequal → frequency = 0.
//        Therefore, you need to Override the inherited equals method


//        ==       → Are these the SAME object?
//        equals() → Are these objects EQUAL according to their defined equality?


        Collections.sort(list);
        System.out.println(Collections.binarySearch(list, new Student("Daksh", 1, 21, 99.86)));
        System.out.println(Collections.binarySearch(list, new Student("Daksh", 1, 21, 99.86), byAge)); // we can also pass comparator
//        binarySearch() requires the list to be sorted
//        If the list is not sorted, the result is undefined/unreliable.
    }
}
