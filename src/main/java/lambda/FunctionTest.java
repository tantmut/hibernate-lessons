package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

public class FunctionTest {
    public static void main(String[] args) {
        final String hello = "Hello, ";
        Function<String, String> helloFunction = (name) -> hello + name;


        int constant = 100;
        Function<Integer, Integer> adder = x -> x + constant;

        Fun<Double, Double> fun = (x) -> x * 2 + 1;
        double result = fun.apply(3d);

        IntSupplier generator = () -> 3;


        final int factor = 2;

// multiplier accepts an integer value and returns another one, it uses closure
        IntUnaryOperator multiplier = val -> factor * val;
        IntPredicate isEven = val -> val % 2 == 0;

        List<String> fruits = Arrays.asList("apple", "pear", "orange", "banana");

// it will print all fruits in the collection
        fruits.forEach(System.out::println);
    }

    @FunctionalInterface
    public interface Fun<T, R> {
        R apply(T t);

        static void doNothingStatic() {
        }

        default void doNothingByDefault() {
        }
    }
}
