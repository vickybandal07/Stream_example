package com.streams.sample;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// To find highest repeated pattern
public class HighestRepeatedPattern {
    public static void main(String[] args) {
        String input = "bababa";
        int patternLength = 3;

        System.out.println(biggestRedundantSubstring(input));


    }

    public static String biggestRedundantSubstring(String str) {
        return IntStream.range(0, str.length())
                .boxed()
                .flatMap(start -> IntStream.rangeClosed(start + 1, str.length())
                        .mapToObj(end -> str.substring(start, end)))
                .collect(Collectors.toMap(
                        Function.identity(),
                        s -> false,
                        (v1, v2) -> true))
                .entrySet().stream()
                .filter(Map.Entry::getValue)
                .max(Map.Entry.comparingByKey(Comparator.comparingInt(String::length)))
                .map(Map.Entry::getKey)
                .orElse("");
    }
}
