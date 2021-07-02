package com.java.concepts.gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

    public static void finAnagrams(String[] input) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String s : input) {

            char[] word = s.toCharArray();
            Arrays.sort(word);
            String key = new String(word);

            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                hashMap.put(key, list);
            }
        }

        for (String key : hashMap.keySet()) {

            List<String> list = hashMap.get(key);
            for (String value : list)
                System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        String[] input= {"sod","pok", "uda","dos", "kop", "adu"};
        finAnagrams(input);

    }
}
