package com.streams.sample;

import java.util.Arrays;
import java.util.List;

//To find palindrome
public class Palindrome {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "banana", "apple", "Nitin", "aba");

        List<String> palindromeList = words.stream().filter(s -> palindrome(s)).toList();
        System.out.println(palindromeList);
    }

    private static boolean palindrome(String str) {
        StringBuilder word = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            word.append(str.charAt(i));
        }
        return str.equalsIgnoreCase(word.toString());
    }
}
