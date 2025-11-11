package com.streams.sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// To concatenated string from the list
public class ConcatenateString {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
        String concatenatedString = strings.stream().collect(Collectors.joining(", "));
        System.out.println(concatenatedString);
    }
}
