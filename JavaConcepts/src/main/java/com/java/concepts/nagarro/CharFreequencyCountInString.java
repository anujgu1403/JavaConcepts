package com.java.concepts.nagarro;

public class CharFreequencyCountInString {

	public void countAndPrintCharFrequency(String input) {
		int size = 26;
		int[] charArray = new int[size];
		for (int i = 0; i < input.length(); i++) {
			charArray[input.charAt(i) - 'a']++;
		}

		for (int i = 0; i < input.length(); i++) {
			if (charArray[input.charAt(i) - 'a'] != 0) {

				System.out.print(input.charAt(i));
				System.out.println();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
