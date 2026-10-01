package _09_Collections._07_ComparableAndComparator;

/*
    Comparator is an object whose job is: Tell Java how two objects should be compared.

    VERY IMPORTANT POINT:********************************************

    actual rule of Comparator.compare(o1, o2) is simply:
    compare(o1, o2)
    negative → o1 comes BEFORE o2
    0        → o1 and o2 are considered equal in ordering
    positive → o1 comes AFTER o2

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
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
    public String toString() {
        return "Student{Name: " + name + ", id: " + id + ", age: " + age + ", marks: " + marks + "}";
    }
    // Override toString() so Student objects are displayed with their actual field values
    // instead of Object's default ClassName@hashCode representation.
}
public class _01_Comparator {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Daksh", 1, 21, 99.86));
        list.add(new Student("Sneha", 2, 24, 98.45));
        list.add(new Student("Aryan", 3, 20, 99.75));
        list.add(new Student("Shreya", 4, 21,  99.86));


        Comparator<Student> byAge = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // Ascending order
                if(o1.age < o2.age) return -1;
                else if(o1.age > o2.age) return 1;
                else return 0;
                /* Explanation
                        if(o1.age < o2.age) return -1;
                        o1 = 20
                        o2 = 25

                        20 < 25
                        → return -1
                        → o1 comes BEFORE o2
                        So smaller age is placed before larger age.

                        Similarly:
                        if (o1.age > o2.age) return 1;
                        o1 = 25
                        o2 = 20

                        25 > 20
                        → return +1
                        → o1 comes AFTER o2
                        → therefore 20 comes before 25

                        So overall:
                        Smaller age → comes first
                        Larger age  → comes later
                        That's exactly ascending order.
                 */

                // Descending order
//                if(o1.age < o2.age) return 1;
//                else if(o1.age > o2.age) return -1;
//                else return 0;



                // shorter version of above and used majorly in java codebases, but it is also internally uses above concept
                // return Integer.compare(o1.age, o2.age); // ascending order
                // return Integer.compare(o2.age, o1.age);  // descending order
            }
        };
        Comparator<Student> byName = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // ascending
                if(o1.name.compareTo(o2.name) < 0) return -1;
                else if(o1.name.compareTo(o2.name) > 0) return 1;
                else return 0;
                // shorter version:  return o1.name.compareTo(o2.name);

                // descending
//                if(o1.name.compareTo(o2.name) < 0) return 1;
//                else if(o1.name.compareTo(o2.name) > 0) return -1;
//                else return 0;
                // shorted version: return o2.name.compareTo(o1.name);
            }
        };
        Comparator<Student> byNameLength = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.name.length(), o2.name.length()); // ascending order
                //return Integer.compare(o2.name.length(), o1.name.length()); // descending order
            }
        };
        Comparator<Student> byId = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.id, o2.id); // ascending order
                //return Integer.compare(o2.id, o1.id); // descending order
            }
        };
        Comparator<Student> byMarks = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // Sort by marks in ascending order.
                // If marks are equal, sort by name in descending lexicographical order.
                if(o1.marks < o2.marks) return -1;
                else if(o1.marks > o2.marks) return 1;
                else {
                    if(o1.name.compareTo(o2.name) < 0) return 1;
                    else if(o1.name.compareTo(o2.name) > 0) return -1;
                    else return 0;
                    //String implements Comparable<String>, so compareTo() provides its natural lexicographical ordering.

//                    compareTo() returns below values:
//                    0  -> Strings are equal
//                    <0 -> First String comes before second
//                    >0 -> First String comes after second
                }
                //return Double.compare(o1.marks, o2.marks); // ascending order
                //return Double.compare(o2.marks, o1.marks); // descending order
            }
        };

        System.out.println("Sort byAge");
        Collections.sort(list, byAge);
        System.out.println(list);

        System.out.println("Sort byName");
        Collections.sort(list, byName);
        System.out.println(list);

        System.out.println("Sort byNameLength");
        Collections.sort(list, byNameLength);
        System.out.println(list);

        System.out.println("Sort byId");
        Collections.sort(list, byId);
        System.out.println(list);

        System.out.println("Sort by Marks(ascending) & Name(descending)");
        Collections.sort(list, byMarks);
        System.out.println(list);
    }
}
