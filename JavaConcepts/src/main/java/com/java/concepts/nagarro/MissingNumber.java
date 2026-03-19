package com.java.concepts.nagarro;

public class MissingNumber {

    //Integer Overflow. If the array is very large, n * (n + 1) or the actualSum might exceed the maximum value an int
    public int findMissing(int[] numbers){
        int n = numbers.length;
        // total = n*(n+1)/2;
        int expectedSum = n*(n+1)/2;

        int actualSum = 0;
        for(int num: numbers){
            actualSum +=num;
        }
        return  expectedSum - actualSum;
    }

    //This is considered the "cleanest" solution by many interviewers because it completely avoids the overflow problem. XOR has a unique property: A⊕A=0 and A⊕0=A.
    public int findMissingXOR(int[] numbers) {
        int n = numbers.length + 1; // Since one is missing, total count should be length + 1
        int x1 = 0;
        int x2 = 0;

        // XOR all numbers that should be there (1 to n)
        for (int i = 1; i <= n; i++) {
            x1 = x1 ^ i;
        }

        // XOR all numbers actually in the array
        for (int num : numbers) {
            x2 = x2 ^ num;
        }

        // The result of x1 ^ x2 is the missing number
        return x1 ^ x2;
    }

    //If your array is sorted (like in your example), you don't need to look at every single number (O(n)). You can find the missing number in O(logn) time.
    public int findMissingBinarySearch(int[] numbers) {
        int left = 0, right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the element at mid is not mid + 1, the missing element is to the left
            if (numbers[mid] > mid + 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 'left + 1' will be the missing number
        return left + 1;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
         int[] numbers = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        System.out.println(missingNumber.findMissing(numbers));

        int[] numbersXOR = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        System.out.println(missingNumber.findMissingXOR(numbersXOR));

        System.out.println(missingNumber.findMissingBinarySearch(numbersXOR));
    }
}
