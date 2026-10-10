package _10_Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    '::' -> the method reference operator.
    Method reference allows us to refer to a method without invoking it.
    They can be used in the place of a lambda expression when the lambda expression only calls an existing method.
*/
class Student{
    String name;
    public Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class _12_MethodAndConstructorReference{
    public static void print(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        List<String> students = Arrays.asList("Alice", "Bob", "Shivam");

        // using lambda expression
        // forEach() visits each element in the list and performs an action on it.
        // accepts a Consumer, which takes one element and performs an action without returning a value.
        students.forEach(x -> System.out.println(x));

        // =============================================================================
        // Method reference
        // =============================================================================
        // Instead of writing
        students.forEach(x -> _12_MethodAndConstructorReference.print(x));
        // we can write:
        students.forEach(_12_MethodAndConstructorReference::print);  // we are just giving reference here, not invoking the method & Most IMP: the method has to exist.
        // or
        students.forEach(System.out::println);                       // use the println() instance method of the System.out object to print each element.
        // Distinction:
        //_12_MethodAndConstructorReference::print references your own static method, whereas System.out::println references an instance method of an existing object.


        // if the method is not static then make an object of the class and make reference to method via that object
        //_12_MethodAndConstructorReference test = new _12_MethodAndConstructorReference();
        // students.forEach(test::print);      // with static this gives error? // test::print  // Invalid when print() is static

        // =============================================================================
        // Constructor reference
        // =============================================================================
        //Student::new is a constructor reference. It replaces x -> new Student(x).
        List<String> names = Arrays.asList("Alice", "Bob", "Shivam");
        List<Student> students1 = names.stream().map(x -> new Student(x)).collect(Collectors.toList());
        // using constructor reference instead of lambda expression
        List<Student> students2 = names.stream().map(Student::new).collect(Collectors.toList());

        /*
        // 1. Static method reference
                Function<String, Integer> f1 = Integer::parseInt;
        // Equivalent: s -> Integer.parseInt(s)


        // 2. Instance method reference (specific object)
                Consumer<String> c1 = System.out::println;
        // Equivalent: s -> System.out.println(s)


        // 3. Instance method reference (arbitrary object of a type)
                Function<String, String> f2 = String::toUpperCase;
        // Equivalent: s -> s.toUpperCase()


        // 4. Constructor reference
                Function<String, StringBuilder> f3 = StringBuilder::new;
        // Equivalent: s -> new StringBuilder(s)


        // 5. Constructor reference for a no-argument constructor
                Supplier<ArrayList<String>> f4 = ArrayList::new;
        // Equivalent: () -> new ArrayList<String>()


        // 6. Method reference with filter()
                List<String> names = Arrays.asList("", "Daksh", "Vipul");
                names.stream().filter(String::isEmpty).forEach(System.out::println);
        // Keeps empty strings


        // 7. Method reference with sorting
                names.sort(String::compareToIgnoreCase);
         */
    }
}
