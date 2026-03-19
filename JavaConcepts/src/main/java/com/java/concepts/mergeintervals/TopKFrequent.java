package com.java.concepts.mergeintervals;

import java.util.*;

class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Map frequencies: O(N)
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        // 2. Keep a Min-Heap of size k: O(N log K)
        // We use a Min-Heap so the least frequent stays at the top for easy removal
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a, b) -> countMap.get(a) - countMap.get(b)
        );

        for (int n : countMap.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll(); // Remove the element with the lowest frequency
            }
        }

        // 3. Convert to array: O(K)
        int[] topK = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            topK[i] = heap.poll();
        }
        return topK;
    }

    // Main method to run and verify the code
    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println("Input: nums = [1,1,1,2,2,3], k = 2");
        int[] result = solution.topKFrequent(nums, k);
        System.out.println("Output: " + Arrays.toString(result)); // Expected: [1, 2]
    }
}
