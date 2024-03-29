package main;

import java.util.Arrays;
import java.util.List;

public class D_FunctionComposition {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // double the even numbers and total
        int result = 0;
        for (int e : numbers) {
            if (e % 2 == 0) {
                result += e *2;
            }
        }
        System.out.println(result);

        // function composition - series of operations, also called as pipeline
        System.out.println(
            numbers.stream()
                    .filter(e -> e % 2 == 0)
                    .map(e -> e * 2)
                    .reduce(0, Integer::sum)
        );

        // the above code can be written like this as well
        System.out.println(
            numbers.stream()
                    .filter(e -> e % 2 == 0)
                    .mapToInt(e -> e *2)
                    .sum()
        );
    }
}
