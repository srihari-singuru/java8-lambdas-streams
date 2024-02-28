package main;

import java.util.Arrays;
import java.util.List;

public class C_MethodReferenceTwoParameters {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // if there are two parameters, and the method is not changing the order
        // and not manipulating the parameters, then method reference can be applied
        System.out.println(
                numbers.stream()
                        //.reduce(0, (total, element) -> Integer.sum(total, element))
                        .reduce(0, Integer::sum)
        );

        // the two parameters may not be parameters at right side
        // an operation on first parameter can be performed on another parameter
        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        //.reduce("", (carry, str) -> carry.concat(str))
                        .reduce("", String::concat)
        );
    }
}
