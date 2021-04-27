package com.java.concepts.blume;

public class StringDuplication {
    public static void main(String[] args) {
        String input = "sdasaddsfadf";
        StringBuffer sb = new StringBuffer();
        input.chars().distinct().forEach(letter->sb.append((char)letter));

        System.out.println("Removed duplicate chars: "+sb);
    }
}
