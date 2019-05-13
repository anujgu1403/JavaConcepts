package com.java.concepts.sorting;

public class QuickSort {
	int[] tempArray;

	int partition(int[] arr, int low, int high) {
		int pivot = arr[(low + high) / 2];
		while (low <= high) {
			while (arr[low] < pivot) {
				low++;
			}
			while (arr[high] > pivot) {
				high--;
			}
			if (low <= high) {
				int temp;
				temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
				high--;
			}
		}
		return low;
	}

	void quickSortRecursion(int[] arr, int low, int high) {

		int pi = partition(arr, low, high);
		if (low < pi - 1) {
			quickSortRecursion(arr, low, pi - 1);
		}
		if (pi < high) {
			quickSortRecursion(arr, pi, high);
		}
	}

	void quickSort(int[] arr, int low, int high) {
		this.tempArray = arr;
		quickSortRecursion(tempArray, 0, tempArray.length - 1);
		for (int i : tempArray) {
			System.out.print(i + " ");
		}

	}

	public static void main(String[] args) {
		int a[] = { 12, 10000, 43, 12, 49, 30, 897 };
		QuickSort qs = new QuickSort();
		qs.quickSort(a, 0, a.length - 1);
	}
}
