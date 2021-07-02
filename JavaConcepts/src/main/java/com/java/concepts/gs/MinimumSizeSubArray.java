package com.java.concepts.gs;

public class MinimumSizeSubArray {

    public int findMinimumSubArray(int[] input, int target) {

        int length = input.length;
        int minLength = 0;

        for (int i = 0; i < length; i++) {
            int sum = input[i];

            if (sum > target)
                return 1;

            for (int j = i + 1; j < length; j++) {
                sum += input[j];
                if (sum > target && (j - i + 1) < length) {
                    minLength = j - i + 1;
                }
            }
        }
        return minLength;
    }

    public int findMinimumSubArrayII(int[] input, int target) {

        int length = input.length;
        int minLength = length + 1, sum = 0, start = 0, end = 0;

        while (end < length) {
            while (sum <= target && end < length) {
                sum += input[end++];
            }

            while (sum > target && start < length) {
                if (end - start < minLength)
                    minLength = end - start;
                sum -= input[start++];
            }
        }

        return minLength;

    }

    public static void main(String[] args) {
        int[] input = {1, 10, 5, 2, 7};
        MinimumSizeSubArray obj = new MinimumSizeSubArray();
        System.out.println(obj.findMinimumSubArray(input, 9));

        System.out.println(obj.findMinimumSubArrayII(input, 9));
    }
}
