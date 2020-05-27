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
		int middle = arr[start];
		while(left < right) {
			while (left < right && arr[right] > middle) {
				right--;
			}
			if(left < right) {
				arr[left++] = arr[right];
			}
			while (left < right && arr[left] <= middle) {
				left++;
			}
			if(left < right) {
				arr[right--] = arr[left];
			}
		}
		arr[left] = middle;
		sort(arr, start, left-1);
		sort(arr,left+1, end);
	}
}
