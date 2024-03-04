package main;

import java.util.Arrays;
import java.util.List;

public class F_StreamCommonOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2.0)
                        .reduce(0.0, (total, element) -> Double.sum(total, element))
        );
        // filter       : filters the values
        // filter       : 0 <= no of elements in output <= number of elements in input
        // parameter    : Stream<T> filter takes Predicate<T>

        // map          : transforms the values
        // map          : no of elements in output == number of elements in input.
        // input type and output type can be different
        // parameter    : Stream<T> map takes Function<T, R> and returns Stream<R>

        // reduce       : cuts across the swimlanes
        // parameter    : Stream<T> reduce takes two parameters
        // first parameter  : T
        // second parameter : BiFunction<R, T, R> returns R

        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToDouble(e -> e * 2.0)
                        .sum()  // specialized reduce function
        );
    }
}
