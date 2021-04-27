package com.java.concepts.sorting;

//time complexity of O(n²) in the average and worst case, and O(n) in the best case.
//For very small n, Insertion Sort is faster than more efficient algorithms such as Quicksort or Merge Sort
//Space complexity: O(1)
public class InsertionSort {

	public static void insertionSort(int a[]) {
		int temp, j;
		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			j = i;
			while (j > 0 && a[j - 1] > temp) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int a[] = { 12, 1, 43 };
		insertionSort(a);
	}

}
