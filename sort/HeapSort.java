package com.data.sort;

import java.util.Arrays;

public class HeapSort {
	public static void sort(int[] arr) {
		int len = arr.length;
		for(int i = 1; i < len; i++) {
			add(arr,i);
		}
		for(int i = len - 1; i > 0; i--) {
			int temp = remove(arr, i);
			arr[i] = temp;
		}
		System.out.print("Heap sort:   " + Arrays.toString(arr));
		System.out.println();
	}

	private static void add(int[] arr, int index) {
		int insertVal = arr[index];
		int insertPos = index;
		while(insertPos > 0) {
			if(insertVal > arr[parent(insertPos)]) {
				arr[insertPos] = arr[parent(insertPos)];
				insertPos = parent(insertPos);
			}else {
				break;
			}
		}
		arr[insertPos] = insertVal;
	}
	private static int parent(int insertPos) {
		return (insertPos - 1) /2;
	}

	private static int remove(int[] arr, int size) {
		int returnVal = arr[0];
		int sinkVal = arr[size];
		int index = 0;
		while(index < size) {
			//right child exists, left child must exist
			if(right(index) < size) {
				if(arr[left(index)] > arr[right(index)] && arr[left(index)] > sinkVal) {
					arr[index] = arr[left(index)];
					index = left(index);
				}else if (arr[right(index)] >= arr[left(index)] && arr[right(index)] > sinkVal) {
					arr[index] = arr[right(index)];
					index = right(index);
				}else {
					break;
				}
			}else {
				//left child exists
				if(left(index) < size && arr[left(index)] > sinkVal) {
					arr[index] = arr[left(index)];
					index = left(index);
				}else {
					break;
				}
			}
		}
		arr[index] = sinkVal;
		return returnVal;
	}

	private static int left(int index) {
		return 2 * index + 1;
	}

	private static int right(int index) {
		return 2 * index + 2;
	}
}
