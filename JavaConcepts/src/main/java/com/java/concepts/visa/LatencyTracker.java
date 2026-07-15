package com.java.concepts.visa;

public class LatencyTracker {
    public static double findMaxAverage(int[] nums, int k) {
        // Edge Case Protection
        if (nums == null || nums.length == 0 || k > nums.length || k <= 0) {
            return 0.0;
        }

        // Calculate sum of the initial window
        long currentWindowSum = 0;
        for (int i = 0; i < k; i++) {
            currentWindowSum += nums[i];
        }

        long maxSum = currentWindowSum;

        // Slide the window across the rest of the array
        for (int i = k; i < nums.length; i++) {
            // Add incoming element, drop outgoing element
            currentWindowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentWindowSum);
        }

        // Cast to double at the very end to preserve precision without float-rounding errors mid-loop
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, -2, 3, 94, 5}, 2));
    }
}
