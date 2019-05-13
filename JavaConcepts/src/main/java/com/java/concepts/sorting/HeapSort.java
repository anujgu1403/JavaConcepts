package com.java.concepts.sorting;

public class HeapSort {

	void heapify(int arr[], int n, int i) {
		int largest = i;
		int li = 2 * i + 1;
		int ri = 2 * i + 2;
		if (li < n && arr[li] > arr[largest]) {
			largest = li;
		}
		if (ri < n && arr[ri] > arr[largest]) {
			largest = ri;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
	}

	void heapSort(int arr[]) {
		int length = arr.length;
		for (int i = (length / 2) - 1; i >= 0; i--) {
			heapify(arr, length, i);
		}
		for (int i = length - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
		
		//Display the sorted array
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	public static void main(String[] args) {
		int a[] = { 12, 10000,1,45, 43, 12, 49, 30, 897 };
		HeapSort hs = new HeapSort();
		hs.heapSort(a);

	}

}
