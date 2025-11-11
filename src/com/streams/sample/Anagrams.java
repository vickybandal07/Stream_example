package com.streams.sample;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//To find anagrams from the given word or array list
public class Anagrams {
    public static void main(String[] args) {
        String[] words = {"pat", "tap", "pan", "Team", "tree", "meat"};

        findAnagramsList(words);
        ifAnagramsWords("RaceCar", "CarRace");
    }

    // Checks and prints whether two words are anagrams
    static void ifAnagramsWords(String s1, String s2) {
        if (s1 == null || s2 == null) {
            System.out.println("Input strings must not be null");
            return;
        }
        String sorted1 = Stream.of(s1.toLowerCase().split(""))
                .sorted()
                .collect(Collectors.joining());

        String sorted2 = Stream.of(s2.toLowerCase().split(""))
                .sorted()
                .collect(Collectors.joining());

        if (sorted1.equals(sorted2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }
    }

    // Finds and prints groups of anagrams from an array of words
    static void findAnagramsList(String[] words) {
        if (words == null || words.length == 0) {
            System.out.println("No words provided.");
            return;
        }

        Map<String, List<String>> anagramGroups = Arrays.stream(words)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        word -> word.toLowerCase().chars()
                                .sorted()
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                .toString()
                ));

        System.out.println("Anagram groups:");
        anagramGroups.values().stream()
                .filter(group -> group.size() > 1)
                .forEach(group -> System.out.println(group));
    }
}
