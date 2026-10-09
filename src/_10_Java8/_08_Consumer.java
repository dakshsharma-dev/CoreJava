package _10_Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class _08_Consumer {
    public static void main(String[] args) {

        // Consumer<T> takes an input of type T and performs an action.
        // It does NOT return any result.
        // Its abstract method is accept(T value).

        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Vipul"); // Executes the action on "Vipul"


        Consumer<List<Integer>> listConsumer = li -> {
            for (Integer i : li) {
                System.out.println(i + 100);
            }
        };

        Consumer<List<Integer>> listConsumer2 = li -> {
            for (Integer i : li) {
                System.out.println(i);
            }
        };

        listConsumer.accept(Arrays.asList(1, 2, 3, 4));
        // Prints each element after adding 100.


        // Consumer chaining using andThen():
        // First execute listConsumer2, then listConsumer.
        // Both Consumers receive the SAME input list.

        listConsumer2.andThen(listConsumer)
                .accept(Arrays.asList(5, 6, 7, 8));

        // First prints: 5, 6, 7, 8
        // Then prints: 105, 106, 107, 108
    }
}