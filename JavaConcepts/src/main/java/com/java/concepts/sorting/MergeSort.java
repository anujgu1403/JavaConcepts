package com.java.concepts.sorting;

public class MergeSort {

	int[] array;
	int[] tempMergeArr;
	int length;

	public void mergeSort(int[] inputArray) {
		this.array = inputArray;
		this.length = inputArray.length;
		this.tempMergeArr = new int[length];
		divideArray(0, length - 1);
		

		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	public void divideArray(int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			int middleIndex = lowerIndex + (higherIndex-lowerIndex) / 2;
			divideArray(lowerIndex, middleIndex);

			divideArray(middleIndex + 1, higherIndex);

			mergeArray(lowerIndex, middleIndex, higherIndex);
		}
	}

	public void mergeArray(int lowerIndex, int middleIndex, int higherIndex) {
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergeArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middleIndex + 1;
		int k = lowerIndex;

		while (i<=middleIndex && j<=higherIndex) {
			if(tempMergeArr[i]<=tempMergeArr[j]){
				array[k]=tempMergeArr[i];
				i++;
			}else{
				array[k]=tempMergeArr[j];
				j++;
			}
			k++;
		}
		while(i<=middleIndex){
			array[k]=tempMergeArr[i];
			i++;
			k++;
		}
	}

	public static void main(String[] args) {
		int a[] = { 12, 1, 43, 12, 49, 30 };
		MergeSort ms= new MergeSort();		
		ms.mergeSort(a);
	}

}
