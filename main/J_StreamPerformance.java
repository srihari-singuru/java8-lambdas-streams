package main;

import java.util.Arrays;
import java.util.List;

public class J_StreamPerformance {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // find the first even number which is greater than 3 and double it.

        // let us look at imperative way fist
        int result = 0;
        for (int e : numbers) {
            if(e > 3 && e % 2 == 0) {   // total 5 units of work
                result = e * 2;
                break;
            }
        }
        System.out.println(result);

        // let us look at functional way
        System.out.println(
                numbers.stream()
                        .filter(e -> e > 3)         // 10 units of work (wrong)
                        .filter(e -> e % 2 == 0)    // 7 units of work (wrong)
                        .map(e -> e * 2)            // 7 units of work (wrong)
                        .findFirst()                // 1 unit of work (wrong)
        );
        // we assume it is total of 25 units of work, hence imperative is faster than functional
        // However, stream creates only pipeline, but doesn't perform anything until a terminal operation is performed
        // it is called lazy evaluation
        
        // let us prove that using extracted methods
        System.out.println(
                numbers.stream()
                        .filter(J_StreamPerformance::isGreaterThanThree)
                        .filter(J_StreamPerformance::isEven)
                        .map(J_StreamPerformance::doubleIt)
                        .findFirst()
        );
        // if we observe the loggers, then we can see the units of work is as same as imperative
    }

    private static boolean isGreaterThanThree(Integer e) {
        System.out.println("isGreaterThanThree: " + e);
        return e > 3;
    }

    private static boolean isEven(Integer e) {
        System.out.println("isEven: " + e);
        return e % 2 == 0;
    }

    private static int doubleIt(Integer e) {
        System.out.println("doubleIt: " + e);
        return e * 2;
    }
}
