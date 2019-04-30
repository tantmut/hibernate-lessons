package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class flatMap {
    public static void main(String[] args) {

        final List<Book> javaBooks = Stream.of(
                new Book("Java EE 7 Essentials", 2013, Arrays.asList("Arun Gupta")),
                new Book("Algorithms", 2011, Arrays.asList("Robert Sedgewick", "Kevin Wayne")),
                new Book("Clean code", 2014, Arrays.asList("Robert Martin"))
        ).collect(Collectors.toList());

         final List<String> authors = javaBooks.stream()
                .flatMap(book -> book.getAuthors().stream())
                .distinct()
                .collect(Collectors.toList());


         authors.forEach(i-> System.out.println(i));
    }
}
