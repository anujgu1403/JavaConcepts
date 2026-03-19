package com.java.concepts.mergeintervals;

import java.util.*;

class IntervalMerger {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by start time: O(N log N)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlap: Update the end of the current interval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap: Move to the next interval
                currentInterval = interval;
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        IntervalMerger intervalMerger = new IntervalMerger();
        int[][] input= {{1,3}, {2,5}, {1,5},{2, 7},{1,5}};
       int[][] result = intervalMerger.merge(input);
       for(int[] interval: result){
           System.out.println(Arrays.toString(interval));
       }

    }
}