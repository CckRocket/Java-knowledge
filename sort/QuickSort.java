package com.data.sort;

import java.util.Arrays;

public class QuickSort {
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
		System.out.print("Quick sort:  " + Arrays.toString(arr));
		System.out.println();
	}
	private static void sort(int[] arr, int start, int end) {
		if(start >= end) return;
		int left = start;
		int right = end;
		int middleVal = median3(arr, left, right);
		while(left < right) {
			while (left < right && arr[right] > middleVal) {
				right--;
			}
			if(left < right) {
				arr[left++] = arr[right];
			}
			while (left < right && arr[left] <= middleVal) {
				left++;
			}
			if(left < right) {
				arr[right--] = arr[left];
			}
		}
		arr[left] = middleVal;
		sort(arr, start, left-1);
		sort(arr,left+1, end);
	}
	private static int median3(int[] arr, int left, int right) {
		int midIndex = (left + right) / 2;
		int temp;
		if(arr[left] > arr[midIndex]) {
			temp = arr[left];
			arr[left] = arr[midIndex];
			arr[midIndex] = temp;
		}
		if(arr[midIndex] > arr[right]) {
			temp = arr[midIndex];
			arr[midIndex] = arr[right];
			arr[right] = temp;
		}
		if(arr[left] > arr[midIndex]) {
			temp = arr[left];
			arr[left] = arr[midIndex];
			arr[midIndex] = temp;
		}
		temp = arr[left];
		arr[left] = arr[midIndex];
		arr[midIndex] = temp;
		return arr[left];
	}
}
