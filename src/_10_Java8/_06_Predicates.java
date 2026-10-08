package _10_Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
/*
     Predicate<T> is a functional interface representing a condition:
         T -> boolean
     It allows us to store a condition in a variable and reuse it,
     instead of creating a separate method for every condition.

     test(value) → executes the predicate and returns true/false.
 
     filter(predicate) → keeps elements for which the predicate returns true.

     Predicate composition:
         and()    → true only if BOTH predicates are true
         or()     → true if AT LEAST ONE predicate is true
         negate() → reverses the result (true ↔ false)

     Predicate.isEqual(value) → creates a predicate that checks equality
     using Objects.equals(), making it null-safe.

     A Predicate can work with any reference type:
         Predicate<Integer>
         Predicate<String>
         Predicate<Student>

     Since Predicate is a Functional Interface (SAM), lambda expressions
     can be used to provide its implementation.
*/
public class _06_Predicates {
    public static void main(String[] args) {
        // store condition in variable instead of creating a method for it -> predicate
        // or
        // Predicate = a reusable condition that takes one input and returns boolean.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);


        Predicate<Integer> salaryGreaterThanOneLac = x -> x > 100000;
        System.out.println(salaryGreaterThanOneLac.test(100000000));
        int salary = 90;
        if(salaryGreaterThanOneLac.test(salary)){
            System.out.println("salary is greater than 100000");
        }


        Predicate<Integer> isEven = x -> x % 2 == 0;
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        for(Integer i: numbers1){
            if(isEven.test(i)){
                System.out.println(i);
            }
        }

        Predicate<String> startsWithLetterV = x -> x.toLowerCase().charAt(0) == 'v';
        System.out.println(startsWithLetterV.test("daksh"));



        Predicate<String> endsWithLetterL = x -> x.toLowerCase().charAt(x.length() - 1) == 'l';
        Predicate<String> and = startsWithLetterV.and(endsWithLetterL);
        Predicate<String> or = startsWithLetterV.or(endsWithLetterL);
        Predicate<String> negate = startsWithLetterV.negate();
        System.out.println(and.test("vipul"));
        System.out.println(or.test("vipu"));
        System.out.println(negate.test("vipu"));
        System.out.println(startsWithLetterV.negate().test("vipul"));


        Student s1 = new Student("Daksh", 20);
        Student s2 = new Student("Sneha", 24);
        Predicate<Student> studentPredicate = x -> x.getAge() > 20;
        System.out.println(studentPredicate.test(s2));


        Predicate<Object> predicate = Predicate.isEqual("Daksh");
        System.out.println(predicate.test("Daksh"));
    }
    static class Student{
        private String name;
        private int age;
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
