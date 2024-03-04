package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class G_SharedMutability {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // the requirement is to double the even numbers and put them into a list

        // The below is the wrong way to do this
        List<Integer> listOfEven1 = new ArrayList<>();  // shared variable
        numbers.stream()    // this can anytime become parallel stream by any developer
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(e -> listOfEven1.add(e));
        System.out.println(listOfEven1);
        // mutability is OK, sharing is OK, but shared mutability is very bad
        // if the stream is replaced with parallel stream, then deadlocks and concurrency issues occur

        // now, let us see the right way to deal with it.
        List<Integer> listOfEven2 =
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .collect(Collectors.toList());  // No worries of concurrency even if parallel stream is used
        System.out.println(listOfEven2);
    }
}
