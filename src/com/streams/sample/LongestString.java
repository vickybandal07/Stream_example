package com.streams.sample;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

//To find longest string in a list in ascending order
public class LongestString {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "aanana", "orange", "grape");

        String longest = list.stream()
                .sorted(comparing(String::length).reversed().thenComparing(String::compareTo))
                .findFirst()
                .orElse(null);


        System.out.println("LongestBySort 1: " + longest);


        Optional<List<String>> shortestStringsOpt = list.stream()
                .collect(Collectors.groupingBy(String::length))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue);

        List<String> longestStringList = shortestStringsOpt.orElse(Collections.emptyList());

        String longest2 = longestStringList.stream().sorted(String::compareTo).findFirst().orElse(null);

        System.out.println("LongestByMax 2 : " + longest2);

    }
}
