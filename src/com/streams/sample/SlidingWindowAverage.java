package com.streams.sample;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//To find average of given window size from the list
public class SlidingWindowAverage {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60);
        List<Double> averages = averageOfConsecutive(numbers, 2);
        System.out.println("Averages of three consecutive numbers: " + averages);

        List<Map.Entry<Integer, Double>> result = averagesWithIndices(numbers, 2);

        result.forEach(entry ->
                System.out.println("Start index: " + entry.getKey() + ", Average: " + entry.getValue()));
    }

    public static List<Double> averageOfConsecutive(List<Integer> list, int windowSize) {
        if (list == null || list.size() < windowSize) return Collections.emptyList();
        return IntStream.range(0, list.size() - windowSize + 1)
                .mapToDouble(i -> list.subList(i, i + windowSize).stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0))
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Map.Entry<Integer, Double>> averagesWithIndices(List<Integer> list, int windowSize) {
        if (list == null || list.size() < windowSize) return Collections.emptyList();
        return IntStream.range(0, list.size() - (windowSize - 1))
                .mapToObj(i -> {
                    double average = list.subList(i, i + windowSize).stream()
                            .mapToInt(Integer::intValue)
                            .average()
                            .orElse(0.0);
                    return new AbstractMap.SimpleEntry<>(i, average);
                })
                .collect(Collectors.toList());
    }
}
