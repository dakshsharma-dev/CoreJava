package _10_Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class _07_FunctionInterface {
    public static void main(String[] args) {

        // Function<T, R> represents a function that:
        // takes an input of type T and returns a result of type R.
        // T = input type, R = return type.
        Function<String, Integer> function = x -> x.length();

        System.out.println(function.apply("Hello"));
        // apply() executes the function.


        // Function can also transform one value into another value
        // of the same or different type.
        Function<String, String> function2 =
                s -> s.substring(0, 3).toLowerCase();

        Function<List<Student>, List<Student>> studentWithVipAsPrefix = li -> {
            List<Student> res = new ArrayList<>();

            for (Student s : li) {
                if (function2.apply(s.getName()).equals("vip")) {
                    res.add(s);
                }
            }

            return res;
        };

        Student s1 = new Student(1, "Vipul");
        Student s2 = new Student(2, "Vipulav");
        Student s3 = new Student(3, "arnav");

        List<Student> students = Arrays.asList(s1, s2, s3);

        List<Student> filteredStudents =
                studentWithVipAsPrefix.apply(students);

        System.out.println(filteredStudents);


        // ================= FUNCTION CHAINING =================

        Function<String, String> f1 = s -> s.toUpperCase();
        Function<String, String> f2 = s -> s.substring(0, 3);

        // andThen():
        // First execute f1, then execute f2 on f1's result.
        //
        // "vipul" -> f1 -> "VIPUL" -> f2 -> "VIP"
        Function<String, String> stringStringFunction = f1.andThen(f2);

        System.out.println(stringStringFunction.apply("vipul"));

        // Same thing, without storing the chained function.
        System.out.println(f1.andThen(f2).apply("vipul"));


        // ================= andThen() vs compose() =================

        Function<Integer, Integer> f3 = x -> 2 * x;
        Function<Integer, Integer> f4 = x -> x * x * x;

        // f3.andThen(f4):
        // f3 first -> f4 second
        //
        // 2 -> f3 -> 4 -> f4 -> 64
        System.out.println(f3.andThen(f4).apply(2)); // 64


        // f4.andThen(f3):
        // f4 first -> f3 second
        //
        // 2 -> f4 -> 8 -> f3 -> 16
        System.out.println(f4.andThen(f3).apply(2)); // 16

        // compose():
        // f4.compose(f3) means:
        // f3 first -> f4 second
        //
        // IMPORTANT:
        // f4.compose(f3) == f3.andThen(f4)
        System.out.println(f4.compose(f3).apply(2)); // 64


        // ================= identity() =================

        // Function.identity() returns a Function that
        // simply returns the same value it receives.
        Function<String, String> identityFunction = Function.identity();

        System.out.println(identityFunction.apply("Vipul")); // Vipul
    }


    private static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}