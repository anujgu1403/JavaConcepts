package com.java.concepts.sorting;

//The time complexity for selection sort is O(n^2) in all three cases
//Space complexity: O(1)
public class SelectionSort {

	public static void insertionSort(int a[]) {
		int temp, min;
		for (int i = 0; i < a.length; i++) {
			min=i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;					
				}
			}
			temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int a[] = { 12, 1, 43, 12, 49, 30 };
		insertionSort(a);

	}

}
