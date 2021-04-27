package com.java.concepts.nagarro;

public class CharFrequencyCountInString {

    public void countAndPrintCharFrequency(String input) {
        int size = 26;
        int[] charArray = new int[size];
        for (int i = 0; i < input.length(); i++) {
            charArray[input.charAt(i) - 'a']++;
        }

        int first = 0, secound = 0;
        for (int i = 0; i < size; i++) {
            if (charArray[first] < charArray[i]) {
                secound = first;
                first = i;
            } else if (charArray[i] > charArray[secound] && charArray[i] < charArray[first]) {
                secound = i;
            }
        }
        System.out.println("2nd largest frequency: " + charArray[secound]);

        for (int i = 0; i < input.length(); i++) {
            var count = input.charAt(i);
            if (charArray[count-'a'] != 0) {
                System.out.print(input.charAt(i));
                System.out.print(charArray[count - 'a'] + " ");

                charArray[input.charAt(i) - 'a'] = 0;
            }
        }


    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CharFrequencyCountInString obj = new CharFrequencyCountInString();
        obj.countAndPrintCharFrequency("fafsdkjfhaksdfbnbnnnnn");

    }

}
