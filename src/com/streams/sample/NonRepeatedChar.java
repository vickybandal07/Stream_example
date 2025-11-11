package com.streams.sample;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

//Find the nonrepeated character in a string, with consideration for
// lowercase conversion and ordering by frequency
public class NonRepeatedChar {

    public static void main(String[] args) {

        String word = "street";

        char nonRepeatedChar = word.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(s -> (char) s.getKey())
                .findFirst().orElse(null);

        System.out.println(nonRepeatedChar);

    }
}
