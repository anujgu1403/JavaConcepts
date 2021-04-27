package com.java.concepts.blume;

import java.util.Arrays;
import java.util.List;

public class FindCombination {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 8, 5, 4);
        int count = 0;
        for (int i = 0; i < list.size() - 1; i++) {

            for (int j = i + 1; j < list.size() - 1; j++) {
                int sum = list.get(i) + list.get(j);
                if (list.contains(sum)) {
                    count++;
                    System.out.println("Possible combinations:" + list.get(i) + "," + list.get(j));
                }
            }
        }
        System.out.println("Total no combinations: " + count);
    }
}
