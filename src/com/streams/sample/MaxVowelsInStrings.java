package com.streams.sample;

import java.util.*;

//To find maximum vowels in string
public class MaxVowelsInStrings {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "java", "stream", "aeiou");
        Map<String, Integer> maxVowelsCount = maxVowels(list);
        System.out.println("Maximum number of vowels in any string: " + maxVowelsCount);
    }

    public static Map<String, Integer> maxVowels(List<String> list) {
        return list.stream()
                .map(s -> new AbstractMap.SimpleEntry<>(s, countVowels(s))).toList().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> Collections.singletonMap(entry.getKey(), entry.getValue()))
                .orElse(Collections.emptyMap());
    }

    private static int countVowels(String s) {
        return (int) s.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
    }

}
