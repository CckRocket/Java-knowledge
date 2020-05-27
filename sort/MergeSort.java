package com.data.sort;

import java.util.Arrays;

public class MergeSort {
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length-1);
		System.out.print("Merge sort:  " + Arrays.toString(arr));
		System.out.println();
	}
	private static void sort(int[] arr, int start, int end) {
		if(start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		sort(arr, start, mid);
		sort(arr, mid+1, end);
		merge(arr, start, mid, end);
	}
	private static void merge(int[] arr, int start, int mid, int end) {
		int len = end - start + 1;
		int[] tempArr = new int[len];
		int tempIndex = 0;
		int left = start;
		int right = mid + 1;
		while(left <= mid && right <= end) {
			tempArr[tempIndex++] = (arr[left] <= arr[right]) ? arr[left++] : arr[right++];
		}
		while(left <= mid) {
			tempArr[tempIndex++] = arr[left++];
		}
		while(right <= end) {
			tempArr[tempIndex++] = arr[right++];
		}
		for(int i = 0; i < len; i++) {
			arr[start+i] = tempArr[i];
		}
	}
}
