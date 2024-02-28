package main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class A_PrintListOfNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // external iterators
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        // another external iterators
        for (int e : numbers) {
            System.out.println(e);
        }

        // internal iterator
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        // replacing anonymous with lambda = reducing noise
        numbers.forEach((Integer value) -> System.out.println(value));

        // java 8 has type inference just for lambda expressions
        numbers.forEach((value) -> System.out.println(value));

        // parenthesis is optional but only for one parameter lambdas
        numbers.forEach(value -> System.out.println(value));

        // if no operation is being performed on the value, then replace it with method reference
        numbers.forEach(System.out::println);

        // lambdas are too cute, so keep it that way.
        // even two lines maybe too much. keep as many fewer lines as possible
    }
}
