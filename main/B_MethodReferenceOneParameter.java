package main;

import java.util.Arrays;
import java.util.List;

public class B_MethodReferenceOneParameter {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Method reference can be used on instance methods
        // obj.print(value) === obj::print
        numbers.forEach(System.out::println);

        // Method reference can be applied on static methods
        // String.valueOf(value) === String::valueOf
        numbers.stream()
                .map(String::valueOf)
                .forEach(System.out::println);

        // Method reference can be applied on methods on target element
        // value.toString() === String::toString (assume value is String here)
        numbers.stream()
                .map(String::valueOf)           // Method reference on static method
                .map(String::toString)          // Method reference on target element
                .forEach(System.out::println);  // Method reference on instance method
    }
}
