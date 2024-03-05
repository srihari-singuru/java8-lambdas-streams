package main;

import java.util.Arrays;
import java.util.List;

public class K_StreamProperties {
    public static void main(String[] args) {
        // Stream properties are - Size, Order, Distinct, Sort

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
        // sized, ordered, non-distinct, non-sorted

        numbers.stream()
                .filter(e -> e % 2 == 0)
                .sorted()
                .forEach(System.out::println);
        // sized, ordered, non-distinct, sorted

        numbers.stream()
                .filter(e -> e % 2 == 0)
                .sorted()
                .distinct()
                .forEach(System.out::println);
        // sized, ordered, distinct, sorted
    }
}
