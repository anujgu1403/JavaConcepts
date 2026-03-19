package com.java.concepts.nagarro;

import java.util.Arrays;

public class AnagramChecker {
    public boolean isAnagram(String s1, String s2) {

        // 1. Remove whitespace and convert to lowercase for uniform comparison
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        // 2. If lengths differ, they cannot be anagrams
        if (s1.length() != s2.length()) return false;


        // 3. Convert to char arrays and sort
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // 4. Compare sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        AnagramChecker checker = new AnagramChecker();
        System.out.println(checker.isAnagram("Listen", "Silent"));
    }
}
