package com.streams.sample;

import java.util.Arrays;
import java.util.Comparator;

//To find the kth largest element in a list of integers using Java Stream API
public class KLargestElement {
    public static void main(String[] args) {
        int[] intArray = {1, 12, 23, 34, 44, 2, 124, 425, 25, 10, 2, 23};

        int k = 3;
        int kthLargest = Arrays.stream(intArray)
                .mapToObj(i -> (Integer) i)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(k - 1)
                .findFirst()
                .orElse(null);
        System.out.println(kthLargest);
    }
}
