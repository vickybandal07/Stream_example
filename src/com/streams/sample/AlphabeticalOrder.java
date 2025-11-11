package com.streams.sample;// Write a program to sort a list of strings in alphabetical order using Java Stream API.

import java.util.Arrays;
import java.util.List;

//To sort list in alphabetical order
public class AlphabeticalOrder {
    public static void main(String[] args) {
        String[] words = {"pat", "tap", "pan", "Team", "tree", "meat"};
        List<String> sortedlist = Arrays.asList(words).stream().map(String::toUpperCase).sorted().toList();
        System.out.println(sortedlist);
    }
}
