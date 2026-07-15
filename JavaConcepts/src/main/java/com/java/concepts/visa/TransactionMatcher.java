package com.java.concepts.visa;

import java.util.HashSet;
import java.util.Set;

public class TransactionMatcher {
    public void countUniquePairs(int[] nums, int k) {
        // Edge Case Protection
        if (nums == null || nums.length < 2) {
            return;
        }

        Set<Integer> seen = new HashSet<>();
        Set<Integer> usedInPair = new HashSet<>();
        int pairCount = 0;

        for (int num : nums) {
            int complement = k - num;

            if (seen.contains(complement)) {
                // To ensure the pair is unique regardless of order,
                // we anchor the unique identifier on the smaller value.
                int smallerElement = Math.min(num, complement);

                if (!usedInPair.contains(smallerElement)) {
                    pairCount++;
                    usedInPair.add(smallerElement);
                }
            }
            seen.add(num);
        }

        System.out.println(pairCount);
        System.out.println();
        usedInPair.forEach(System.out::println);
        System.out.println();
        seen.forEach(System.out::println);

    }

    public static void main(String[] args) {
        TransactionMatcher matcher = new TransactionMatcher();
        matcher.countUniquePairs(new int[]{1, 2, 3, 4, 5}, 5);
    }
}