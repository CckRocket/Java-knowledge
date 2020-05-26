package com.data.sort;

import java.util.Arrays;

public class SelectSort {
	public static void sort(int[] arr) {
		int len = arr.length;
		int maxIndex;
		
		for(int i = len - 1; i > 0; i--) {
			maxIndex = i;
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[maxIndex]) {
					maxIndex = j;
				}
			}
			if(maxIndex != i) {
				int temp = arr[i];
				arr[i] = arr[maxIndex];
				arr[maxIndex] = temp;
			}
		}
		
		System.out.print("Select sort: " + Arrays.toString(arr));
		System.out.println();
	}
}
