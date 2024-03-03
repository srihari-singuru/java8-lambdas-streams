package main;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class E_ParallelStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // double the even numbers and total
        TimerCalculator.measureTimeTaken(() ->
            numbers.stream()
                    .filter(e -> e % 2 == 0)
                    .mapToInt(E_ParallelStreams::timeIntensiveOperation)
                    .sum()
        );
        // the above way would complete the processing in about 5 seconds as the sleep time is 1 sec

        // to improve the performance, we can use parallel streams
        // the below way would take about 1 sec even though 5 items to be processed with 1 sec sleep for each element
        // parallel streams uses a lot of resources
        // *** use parallel streams only in below cases
        // 1. The problem on hand is actually parallelizable
        // 2. Willing to spend lot more resources to get the answer faster
        // 3. When the data size is big enough, then only we will get the benefit
        // 4. When the task computation is big enough, then only we will get the benefit in performance
        TimerCalculator.measureTimeTaken(() ->
            numbers.parallelStream()
                    .filter(e -> e % 2 == 0)
                    .mapToInt(E_ParallelStreams::timeIntensiveOperation)
                    .sum()
        );
    }

    private static int timeIntensiveOperation(int e) {
        // assume this is time intensive operation
        try {
            Thread.sleep(1000);
        } catch (Exception ex) { }
        return e * 2;
    }

    private static class TimerCalculator {
        public static void measureTimeTaken(Runnable runnable) {
            Instant now = Instant.now();

            try {
                runnable.run();
            } finally {
                Instant end = Instant.now();
                System.out.println("Time taken: " + Duration.between(now, end).toMillis());
            }
        }
    }
}
