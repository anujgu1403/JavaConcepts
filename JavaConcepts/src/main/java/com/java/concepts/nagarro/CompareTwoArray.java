package com.java.concepts.nagarro;

import java.util.Arrays;

public class CompareTwoArray {

    public static void main(String[] args) {
        int[] ar1 = {2, 3, 1, 5};
        int[] ar2 = {3, 2, 1, 5};
        boolean result = compareArrays(ar1, ar2);
        System.out.println(result ? "Yes" : "NO");
    }

    public static boolean compareArrays(int[] ar1, int[] ar2) {

        int length1 = ar1.length;
        int length2 = ar1.length;
        if (length1 != length2)
            return false;

        Arrays.parallelSort(ar1);
        Arrays.parallelSort(ar2);

        for (int i = 0; i < length1; i++) {
            if (ar1[i] != ar2[i])
                return false;
        }
        return true;
    }
}
