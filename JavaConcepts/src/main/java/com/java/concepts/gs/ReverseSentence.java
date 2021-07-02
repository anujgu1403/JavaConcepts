package com.java.concepts.gs;

public class ReverseSentence {

    public static String reverse(String sentence) {
        if (sentence.isEmpty())
            return sentence;

        StringBuffer sb = new StringBuffer("test");
        sb.reverse();
        return reverse(sentence.substring(1)) + sentence.charAt(0);
    }

    public static void main(String[] args) {
        String input = "This is sentence reverse program";

        System.out.println(reverse(input));
    }
}
