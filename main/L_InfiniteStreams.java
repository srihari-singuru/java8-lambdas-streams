package main;

import java.util.stream.Stream;

public class L_InfiniteStreams {
    // Stream.iterate(100, e -> e + 1);
    // This is an infinite stream starts with 100 and increments by 1 until a terminal operation
    public static void main(String[] args) {
        // given a number k, and a count n, find the total of double of n even numbers
        // starting with k, where square root of each number is greater than 20

        int k = 121;
        int n = 51;
        System.out.println(calculateImperative(k, n));
        System.out.println(calculateFunctional(k, n));
    }

    private static int calculateImperative(int k, int n) {
        int result = 0;

        int index = k;
        int count = 0;
        while (count < n) {
            if (index % 2 == 0 && Math.sqrt(index) > 20) {
                result += index * 2;
                count ++;
            }
            index ++;
        }
        return result;
    }
    // the above method is very difficult to understand, and prone to developer mistakes

    private static int calculateFunctional(int k, int n) {
        return Stream.iterate(k, e -> e + 1)
                .filter(e -> e % 2 == 0)
                .filter(e -> Math.sqrt(e) > 20)
                .mapToInt(e -> e * 2)
                .limit(n)
                .sum();
    }
    // the above is very easy to understand, read, and it is very cohesive. One thing at a time
}
