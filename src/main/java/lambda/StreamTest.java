package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 11, 33);

        List<String> words = Arrays.asList("nazar", "baz", "kar");

        List<Integer> filteredValues = new ArrayList<>();
        for (Integer val : values) {
            if (val >= 10) {
                filteredValues.add(val);
            }
        }

        List<Integer> filteredValues1 = values.stream()
                .filter(val -> val >= 10)
                .collect(Collectors.toList());


        String longWord = words.stream()
                .filter(w -> w.length() < 4)
                .distinct()
                .map(String::toUpperCase)
                .reduce("", String::concat);

        boolean hasValue10 = IntStream.range(1, 10).anyMatch(x -> x == 10);

        System.out.println(hasValue10);




    }
}
