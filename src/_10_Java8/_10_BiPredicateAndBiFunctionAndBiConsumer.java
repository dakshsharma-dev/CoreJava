package _10_Java8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class _10_BiPredicateAndBiFunctionAndBiConsumer {
    public static void main(String[] args) {

        // BiPredicate<T, U> takes TWO inputs and returns a boolean.
        // Its abstract method is test(T t, U u).
        BiPredicate<Integer, Integer> biPredicate =
                (x, y) -> x % 2 == 0 && y % 2 == 0;

        System.out.println(biPredicate.test(2, 4)); // true


        // The two inputs can have DIFFERENT types.
        BiPredicate<String, Integer> biPredicate1 =
                (str, x) -> str.length() == x;

        System.out.println(biPredicate1.test("Daksh", 5)); // true


        // BiFunction<T, U, R> takes TWO inputs and returns a result of type R.
        // Its abstract method is apply(T t, U u).
        BiFunction<String, String, Integer> biFunction =
                (x, y) -> x.length() + y.length();

        System.out.println(biFunction.apply("Daksh", "Shreya")); // 11


        // BiConsumer<T, U> takes TWO inputs and performs an action.
        // It does NOT return a result.
        // Its abstract method is accept(T t, U u).
        BiConsumer<Integer, Integer> biConsumer = (a, b) -> {
            System.out.println(a + b);
        };

        biConsumer.accept(11, 34); // 45


        // There is no standard BiSupplier in java.util.function.
        // Supplier<T> takes no input and returns ONE result.
        // Java allows that result to be an object containing multiple values,
        // such as a List, array, or custom class.
    }
}

