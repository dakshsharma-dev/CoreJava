package _10_Java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class _09_Supplier {
    public static void main(String[] args) {
        // Supplier<T> takes no input and returns a value of type T.
        // Its abstract method is get().
        Supplier<Integer> supplier = () -> 1;
        System.out.println(supplier.get()); // 1

        // 1. Supply a String
        Supplier<String> name = () -> "Daksh";
        System.out.println(name.get()); // Daksh

        // 2. Generate a value when requested
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

        // 3. Supply a new object whenever get() is called
        Supplier<StringBuilder> builder = () -> new StringBuilder();
        System.out.println(builder.get());


        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier1 = () -> 100;

        if(predicate.test(supplier1.get())){
            consumer.accept(function.apply(supplier1.get()));
        }
    }
}
