package com.java.concepts.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockString {

    public static String isValid(String s) {
        // Write your code here
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0)+1);
        }

        int[] freequency= new int[countMap.size()];
        int index=0;
        for(Character ch: countMap.keySet()){
            freequency[index++] = countMap.get(ch);
        }

        Arrays.sort(freequency);

        if(freequency.length==1)
            return "YES";
        int first = freequency[0];
        int second = freequency[1];
        int last = freequency[freequency.length - 1];
        int secondLast = freequency[freequency.length - 2];

        if(first == last)
            return "YES";
        if(first == 1 &&  second == last)
            return "YES";
        if(first == second && second == secondLast && secondLast == (last-1))
            return "YES";

        return "NO";

    }

    public static void main(String[] args) {
        String input = "b";
        System.out.println(isValid(input));
    }
}
