package com.java.concepts.gs;

import java.util.HashMap;
import java.util.Map;

public class StringRunLengthEncoding {

    //1. Using while loop TC:O(n)
    //It will compare only adjacent chars
    public static String runLengthEncodingI(String input) {

        int count;
        String output = "";
        for (int i = 0; i < input.length(); i++) {

            count = 1;
            while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            output = output + (String.valueOf(input.charAt(i)) + count);
        }
        return output;
    }

    //1. Using Map TC:O(n)
    //It will compare char from whole String
    public static void runLengthEncodingII(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (map.containsKey(input.charAt(i))) {
                int count = map.get(input.charAt(i));
                map.put(input.charAt(i), count + 1);
            } else {
                map.put(input.charAt(i), 1);
            }
        }
        for (char key : map.keySet()) {
            System.out.print(map.get(key) + "" + key);
        }
    }

    public static void main(String[] args) {
        String input = "aasakkkawwwbbsdd";
        System.out.println(runLengthEncodingI(input));

        runLengthEncodingII(input);
    }
}
