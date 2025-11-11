package com.streams.sample;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Find the most repeated character in a string, with consideration for
// lowercase conversion and ordering by frequency
public class MostRepeatedChar {

    public static void main(String[] args) {

        String word = "glider";
        char mostRepeatedChar = word.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().min(Comparator.<Map.Entry<Character, Long>>comparingLong(Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println(mostRepeatedChar);
    }
}


