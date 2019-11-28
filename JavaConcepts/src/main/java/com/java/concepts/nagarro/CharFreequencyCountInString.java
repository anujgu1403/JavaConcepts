package com.java.concepts.nagarro;

public class CharFreequencyCountInString {

	public void countAndPrintCharFrequency(String input) {
		int size = 26;
		int[] charArray = new int[size];
		for (int i = 0; i < input.length(); i++) {
			charArray[input.charAt(i)]++;
		}

		int first = 0, secound = 0;
		for (int i = 0; i < size; i++) {
			if(charArray[first]<charArray[i]) {
				secound= first;
				first=i;
			}else if (charArray[i]>charArray[secound] && charArray[i]<charArray[first]) {
				secound = i; 
			}
		}
		System.out.println("2nd largest freequency: "+charArray[secound]);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharFreequencyCountInString obj = new CharFreequencyCountInString();
		obj.countAndPrintCharFrequency("fafsdkjfhaksdfbnbnnnnn");

	}

}
