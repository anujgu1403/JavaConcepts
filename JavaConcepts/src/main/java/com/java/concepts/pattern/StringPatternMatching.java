package com.java.concepts.pattern;

public class StringPatternMatching {

	public static void main(String[] args) {
		String text = "ashjkasjkramkk";
		String pattren = "ramkk";
		int count = 0;
		int ltext = text.length();
		int lpattren = pattren.length();
		char c, a;
		for (int i = 0; i <= ltext - lpattren; i++) {
			c = text.charAt(i);
			a = pattren.charAt(0);
			if (c == a) {
				for (int j = i, k = 0; j < i + lpattren; j++, k++) {
					c = text.charAt(j);
					a = pattren.charAt(k);

					if (c == a)
						count++;
				}
			}
		}
		if (count == lpattren) {
			System.out.println("Pattren found");
		} else {
			System.out.println("Not found");
		}
	}
}
