package _10_Java8;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class _11_UnaryAndBinaryOperatorInterface {
    public static void main(String[] args) {

        Function<Integer, Integer> function1 = x -> x * x;
        Function<String, String> function2 = str -> str.toLowerCase();

        // UnaryOperator<T> is a specialised Function<T, T>.
        // Input and output types must be the same.
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println(unaryOperator.apply(5)); // 25

        UnaryOperator<String> unaryOperator1 = str -> str.toLowerCase();
        System.out.println(unaryOperator1.apply("Daksh")); // daksh


        BiFunction<String, String, String> biFunction =
                (str1, str2) -> str1 + str2;
        System.out.println(biFunction.apply("daksh", "sneha")); // dakshsneha

        // BinaryOperator<T> is a specialised BiFunction<T, T, T>.
        // Both inputs and the output must have the same type.
        BinaryOperator<String> binaryOperator =
                (str1, str2) -> str1 + str2;
        System.out.println(binaryOperator.apply("Daksh", "Shreya")); // DakshShreya
    }
}
