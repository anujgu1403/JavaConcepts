package com.java.concepts.sorting;

public class BubbleSort {

	public static void bubbleSort(int a[]) {
		int temp;
		for (int i = 0; i < a.length; i++) {
			int flag = 0;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = 1;
				}
			}
			if (flag == 0) {
				break;
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	public static void bubbleSortString(String a[]) {
		String temp;
		for (int i = 0; i < a.length; i++) {
			int flag = 0;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j].compareTo(a[j + 1])>0) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = 1;
				}
			}
			if (flag == 0) {
				break;
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}

	public static void main(String[] args) {
		int a[] = { 12, 1, 43, 12, 49, 30 };
		bubbleSort(a);
		String names[]={"Ram", "Anuj", "Singla","Sukhi"};
		bubbleSortString(names);
	}

}
