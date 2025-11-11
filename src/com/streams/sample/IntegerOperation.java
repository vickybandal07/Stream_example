package com.streams.sample;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// All integer operation
public class IntegerOperation {
    public static void main(String[] args) {
        int[] intArray = {1, 12, 23, 34, 44, 2, 124, 425, 25, 10, 2, 23};

        printSumOfEvenNumber(intArray);

        printSumOf(intArray);

        printAverageSquares(intArray);

        printminMax(intArray);

        printPrimeNumber(intArray);

        removeDuplicates(intArray);

        countDuplicates(intArray);
    }

    private static void printSumOfEvenNumber(int[] intArray) {
        int sum = Arrays.stream(intArray).filter(n -> n % 2 == 0).sum();
        System.out.println("Sum of Even integers in array: " + sum);
    }

    private static void printSumOf(int[] intArray) {
        int sum = Arrays.stream(intArray).sum();
        System.out.println("Sum of integers in array: " + sum);
    }

    private static void printAverageSquares(int[] intArray) {
        Double averageSquares = Arrays.stream(intArray).mapToDouble(s -> s * s).average().orElse(0.0);
        System.out.println("Average of Square: " + averageSquares);
    }

    private static void printminMax(int[] intArray) {
        int min = Arrays.stream(intArray).min().getAsInt();
        int max = Arrays.stream(intArray).max().getAsInt();
        System.out.println("minimum: " + min + " maximun: " + max);
    }

    private static void printPrimeNumber(int[] intArray) {
        List<Integer> primeNumbers = Arrays.stream(intArray).filter(IntegerOperation::isPrimeNumer).boxed().toList();
        System.out.println("Prime numbers: " + primeNumbers);
    }

    private static boolean isPrimeNumer(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;  // number divisible by i, so not prime
            }
        }
        return true;
    }

    private static void removeDuplicates(int[] intArray) {
        List<Integer> noDuplicates = Arrays.stream(intArray).sorted().distinct().boxed().toList();
        System.out.println("noDuplicates : " + noDuplicates);
    }


    private static void countDuplicates(int[] intArray) {

        Map<Integer, Long> countMap = Arrays.stream(intArray)
                .boxed() // convert int to Integer for collectors
                .collect(Collectors.groupingBy(
                        s -> s,  // identity function
                        LinkedHashMap::new,  // preserve insertion order
                        Collectors.counting() // count occurrences
                ));
        countMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.println(e.getKey() + " occurs " + e.getValue() + " times"));
    }

}
